package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue

import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class BaseDadosTest {
    private fun appContext() =
        InstrumentationRegistry.getInstrumentation().targetContext

    private fun getWritableDatabase(): SQLiteDatabase {
        val openHelper = BDViagemOpenHelper(appContext())
        return openHelper.writableDatabase
    }

    private fun  insereCliente(db: SQLiteDatabase, cliente: Cliente) {
        cliente.id = TabelaBDCliente(db).insert(cliente.toContentValues())
        assertNotEquals(-1, cliente.id)
    }

    private fun  insereMotorista(db: SQLiteDatabase, motorista: Motorista) {
        motorista.id = TabelaBDMotorista(db).insert(motorista.toContentValues())
        assertNotEquals(-1, motorista.id)
    }

    private fun  insereMercadoria(db: SQLiteDatabase, mercadoria: Mercadoria) {
        mercadoria.id = TabelaBDMercadoria(db).insert(mercadoria.toContentValues())
        assertNotEquals(-1, mercadoria.id)
    }

    private fun  insereViagem(db: SQLiteDatabase, viagem: Viagem) {
        viagem.id = TabelaBDViagem(db).insert(viagem.toContentValues())
        assertNotEquals(-1, viagem.id)
    }

    @Before
    fun apagaBaseDados() {
        appContext().deleteDatabase(BDViagemOpenHelper.NOME)
    }

    @Test
    fun consegueAbrirBaseDados() {
        val openHelper = BDViagemOpenHelper(appContext())
        val db = openHelper.readableDatabase

        assertTrue(db.isOpen)

        db.close()
    }

    @Test
    fun consegueInserirCliente() {
        val db = getWritableDatabase()

        insereCliente(db,Cliente("Teste","30156478","935684257"))
        db.close()
    }

    @Test
    fun consegueInserirMotorista() {
        val db = getWritableDatabase()

        insereMotorista(db, Motorista("Teste","25-Julho-2022","Teste","30156474","932584123","teste@gmail.com"))
        db.close()

    }

    @Test
    fun consegueInserirMercadoria() {
        val db = getWritableDatabase()

        val cliente = Cliente("Teste2","12345678","931234567")
        insereCliente(db, cliente)

        val mercadoria = Mercadoria("Teste","100","102",cliente.id)
        mercadoria.id = TabelaBDMercadoria(db).insert(mercadoria.toContentValues())

        assertNotEquals(-1,mercadoria.id)
        db.close()
    }

    @Test
    fun consegueInserirViagem() {
        val db = getWritableDatabase()

        val cliente = Cliente("TransJanardo","30135618","916598745")
        insereCliente(db, cliente)

        val mercadoria = Mercadoria("Madeira","40000kg","102", cliente.id)
        insereMercadoria(db, mercadoria)

        val motorista = Motorista("Diogo","18-julho-1995","Aveiro", "25654875", "912654732", "diogo@gmail.com")
        insereMotorista(db, motorista)

        val viagem = Viagem("16-junho-2022","17-junho-2022","Aveiro","Salamanca","Express",mercadoria.id,motorista.id)
        viagem.id = TabelaBDViagem(db).insert(viagem.toContentValues())

        assertNotEquals(-1,viagem.id)
        db.close()
    }

    @Test
    fun consegueAlterarCliente() {
        val db = getWritableDatabase()

        val cliente = Cliente("Teste","teste","teste")
        insereCliente(db, cliente)

        cliente.nome = "Transjanardo"
        cliente.cc = "23564897"
        cliente.telemovel = "912546897"

        val registosAlterados = TabelaBDCliente(db).update(
            cliente.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${cliente.id}"))

        assertEquals(1,registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarMotorista() {
        val db = getWritableDatabase()

        val motorista = Motorista("Teste","teste","teste","teste","teste","teste@gmail.com")
        insereMotorista(db, motorista)

        motorista.nome = "João Silva"
        motorista.dataNascimento = "1-janeiro-1990"
        motorista.morada = "Aveiro"
        motorista.cc = "23546987"
        motorista.telemovel = "915468276"
        motorista.email = "joaosilva@gmail.com"

        val registosAlterados = TabelaBDMotorista(db).update(
            motorista.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${motorista.id}"))

        assertEquals(1,registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarMercadoria() {
        val db = getWritableDatabase()

        val cliente = Cliente("Teste2","23165487","915423659")
        insereCliente(db, cliente)

        val mercadoria = Mercadoria("teste","teste","teste", cliente.id)
        insereMercadoria(db, mercadoria)

        mercadoria.tipoMercadoria = "Madeira"
        mercadoria.peso = "45000kg"
        mercadoria.dimensoes = "190"
        mercadoria.clienteId = cliente.id

        val registosAlterados = TabelaBDMotorista(db).update(
            mercadoria.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("$mercadoria.id}"))

        assertEquals(1,registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarViagem() {
        val db = getWritableDatabase()

        val cliente = Cliente("TranSilva","32516454","915423659")
        insereCliente(db, cliente)

        val mercadoria = Mercadoria("Peças Automóveis","20000kg","915", cliente.id)
        insereMercadoria(db, mercadoria)

        val motorista = Motorista("António Marques","22-jun-1997","Viseu","23562458","914523658","antoniomarques@gmail.com")
        insereMotorista(db, motorista)

        val viagem = Viagem("datateste","datateste2","Aveiro","Lisboa","Express", mercadoria.id, motorista.id)
        insereViagem(db, viagem)

        viagem.dataPartida = "12-jan-2022"
        viagem.dataChegada = "12-jan-2022"
        viagem.localPartida = "Aveiro"
        viagem.localChegada = "Viseu"
        viagem.tipoServico = "express"
        viagem.mercadoriaId = mercadoria.id
        viagem.motoristaId = motorista.id

        val registosAlterados = TabelaBDViagem(db).update(
            viagem.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("$viagem.id}"))

        assertEquals(1,registosAlterados)

        db.close()
    }
}