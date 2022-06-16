package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
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
    fun appContext() =
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
}