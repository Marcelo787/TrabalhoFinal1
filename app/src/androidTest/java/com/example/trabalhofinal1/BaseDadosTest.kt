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
        assertNotEquals(1, cliente.id)
    }

    private fun  insereMotorista(db: SQLiteDatabase, motorista: Motorista) {
        motorista.id = TabelaBDMotorista(db).insert(motorista.toContentValues())
        assertNotEquals(1, motorista.id)
    }

    private fun  insereMercadoria(db: SQLiteDatabase, mercadoria: Mercadoria) {
        mercadoria.id = TabelaBDMercadoria(db).insert(mercadoria.toContentValues())
        assertNotEquals(1, mercadoria.id)
    }

    private fun  inserePartida(db: SQLiteDatabase, partida: Partida) {
        partida.id = TabelaBDPartida(db).insert(partida.toContentValues())
        assertNotEquals(1, partida.id)
    }

    private fun  insereChegada(db: SQLiteDatabase, chegada: Chegada) {
        chegada.id = TabelaBDPartida(db).insert(chegada.toContentValues())
        assertNotEquals(1, chegada.id)
    }

    private fun  insereViagem(db: SQLiteDatabase, viagem: Viagem) {
        viagem.id = TabelaBDViagem(db).insert(viagem.toContentValues())
        assertNotEquals(1, viagem.id)
    }

    private fun  insereMercadoriaViagem(db: SQLiteDatabase, mercadoriaViagem: MercadoriaViagem) {
        mercadoriaViagem.id = TabelaBDViagem(db).insert(mercadoriaViagem.toContentValues())
        assertNotEquals(1, mercadoriaViagem.id)
    }

    private fun  insereViagemMotorista(db: SQLiteDatabase, viagemMotorista: ViagemMotorista) {
        viagemMotorista.id = TabelaBDViagem(db).insert(viagemMotorista.toContentValues())
        assertNotEquals(1, viagemMotorista.id)
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

        insereCliente(db,Cliente("Teste","30156478","935684257","teste"))
        db.close()
    }
    @Test
    fun consegueInserirMotorista() {
        val db = getWritableDatabase()

        insereMotorista(db, Motorista("Teste","25-jul-2000","Teste","30156474","932584123","teste@gmail.com"))
        db.close()

    }

    @Test
    fun consegueInserirMercadoria() {
        val db = getWritableDatabase()

        val cliente = Cliente("Teste2","12345678","931234567", "teste")
        insereCliente(db, cliente)

        val mercadoria = Mercadoria("Teste",100.0,102.2,cliente.id)
        insereMercadoria(db, mercadoria)
        db.close()
    }

    @Test
    fun consegueInserirViagem() {
        val db = getWritableDatabase()

        /*
        val partida = Partida("Aveiro","12-Fev-2022")
        inserePartida(db, partida)

        val chegada = Chegada("Viseu","13-Fev-2022")
        insereChegada(db, chegada)

         */


        val viagem = Viagem("Teste3")
        insereViagem(db, viagem)
        db.close()
    }

    @Test
    fun consegueInserirChegada() {
        val db = getWritableDatabase()

        val chegada = Chegada("TransJanardo","30135618")
        insereChegada(db, chegada)

        db.close()
    }

    @Test
    fun consegueInserirPartida() {
        val db = getWritableDatabase()

        val partida = Partida("Teste","teste")
        inserePartida(db, partida)
        db.close()
    }



    @Test
    fun consegueInserirMercadoriaViagem() {
        val db = getWritableDatabase()

        val cliente = Cliente("Aveiro","12-Fev-2022","teste","teste")
        insereCliente(db, cliente)

        val mercadoria= Mercadoria("Aveiro",15.0,102.2, cliente.id)
        insereMercadoria(db, mercadoria)


        val partida = Partida("teste","teste")
        inserePartida(db, partida)

        val chegada = Chegada("teste","teste")
        insereChegada(db, chegada)

        val viagem = Viagem("Teste")
        insereViagem(db, viagem)

        val mercadoriaViagem = MercadoriaViagem(mercadoria.id,viagem.id)
        insereMercadoria(db, mercadoria)
        db.close()
    }

    @Test
    fun consegueInserirViagemMotorista() {
        val db = getWritableDatabase()

        val partida = Partida("teste","teste")
        inserePartida(db, partida)

        val chegada = Chegada("teste","teste")
        insereChegada(db, chegada)

        val viagem = Viagem("teste")
        insereChegada(db, chegada)

        val motorista = Motorista("teste","teste","teste","21543658","915462358","teste")

        val ViagemMotorista = ViagemMotorista(viagem.id, motorista.id)
        ViagemMotorista.id = TabelaBDViagemMotorista(db).insert(ViagemMotorista.toContentValues())

        assertNotEquals(1,ViagemMotorista.id)
        db.close()
    }

    @Test
    fun consegueAlterarCliente() {
        val db = getWritableDatabase()

        val cliente = Cliente("Teste","teste","teste","teste")
        insereCliente(db, cliente)

        cliente.nome = "João Silva"
        cliente.cc = "54231368"
        cliente.telemovel = "912546328"
        cliente.email = "joao@gmail.com"

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

        val cliente = Cliente("Teste2","23165487","915423659","teste@hotmail.com")
        insereCliente(db, cliente)

        val mercadoria = Mercadoria("teste",100.00,50.00, cliente.id)
        insereMercadoria(db, mercadoria)

        mercadoria.tipoMercadoria = "Madeira"
        mercadoria.peso = 234.89
        mercadoria.dimensoes = 53.67
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


        val viagem = Viagem("Teste7")
        insereViagem(db, viagem)

        viagem.nome = "Salamanca_to_Guarda"

        val registosAlterados = TabelaBDViagem(db).update(
            viagem.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("$viagem.id}"))

        assertEquals(1,registosAlterados)

        db.close()
    }

    @Test
    fun  consegueEliminarCliente() {
        val db = getWritableDatabase()

        val cliente = Cliente("SeverTrans","25421365","912546897","Teste4@gmail.com")
        insereCliente(db, cliente)

        val registosEliminados = TabelaBDCliente(db).delete(
            "${BaseColumns._ID}=?",
            arrayOf("${cliente.id}"))

        assertEquals(1, registosEliminados)

        db.close()
    }

    @Test
    fun  consegueEliminarMotorista() {
        val db = getWritableDatabase()

        val motorista = Motorista("Jusué Costa","30-jul-1990","Braga","24521534","912456329","jusuecosta@gmail.com")
        insereMotorista(db, motorista)

        val registosEliminados = TabelaBDMotorista(db).delete(
            "${BaseColumns._ID}=?",
            arrayOf("${motorista.id}"))

        assertEquals(1, registosEliminados)

        db.close()
    }

    @Test
    fun  consegueEliminarMercadoria() {
        val db = getWritableDatabase()

        val cliente = Cliente("Transportes Antonio","53264585","916523459","Teste2@gmail.com")
        insereCliente(db, cliente)

        val mercadoria = Mercadoria("Sapatos",787.454,342.45, cliente.id)
        insereMercadoria(db, mercadoria)

        val registosEliminados = TabelaBDCliente(db).delete(
            "${BaseColumns._ID}=?",
            arrayOf("${mercadoria.id}"))

        assertEquals(1, registosEliminados)

        db.close()
    }

    @Test
    fun  consegueEliminarViagem() {
        val db = getWritableDatabase()

        val viagem = Viagem("Porto_to_Lisboa")
        insereViagem(db, viagem)

        val registosEliminados = TabelaBDViagem(db).delete(
            "${BaseColumns._ID}=?",
            arrayOf("${viagem.id}")
        )

        assertEquals(1, registosEliminados)

        db.close()
    }

    @Test
    fun consegueLerCliente() {
        val db = getWritableDatabase()

        val cliente = Cliente("Teste11","24062022","963852741","Teste5@hotmail.com")
        insereCliente(db, cliente)

        val cursor = TabelaBDCliente(db).query(
            TabelaBDCliente.TODAS_COLUNAS,
            "${BaseColumns._ID}=?",
            arrayOf("${cliente.id}"),
            null,
            null,
            null
        )

        assertEquals(1, cursor.count)
        assertTrue(cursor.moveToNext())

        val clienteBD = Cliente.fromCursor(cursor)

        assertEquals(cliente, clienteBD)

        db.close()
    }

    @Test
    fun consegueLerChegada() {
        val db = getWritableDatabase()

        val chegada = Chegada("Teste11","24062022")
        insereChegada(db, chegada)

        val cursor = TabelaBDChegada(db).query(
            TabelaBDChegada.TODAS_COLUNAS,
            "${BaseColumns._ID}=?",
            arrayOf("${chegada.id}"),
            null,
            null,
            null
        )

        assertEquals(1, cursor.count)
        assertTrue(cursor.moveToNext())

        val chegadaBD = Chegada.fromCursor(cursor)

        assertEquals(chegada, chegadaBD)

        db.close()
    }

    @Test
    fun consegueLerPartida() {
        val db = getWritableDatabase()

        val partida = Partida("Teste11","24062022")
        inserePartida(db, partida)

        val cursor = TabelaBDPartida(db).query(
            TabelaBDPartida.TODAS_COLUNAS,
            "${BaseColumns._ID}=?",
            arrayOf("${partida.id}"),
            null,
            null,
            null
        )

        assertEquals(1, cursor.count)
        assertTrue(cursor.moveToNext())

        val partidaBD = Partida.fromCursor(cursor)

        assertEquals(partida, partidaBD)

        db.close()
    }

    @Test
    fun consegueLerMercadoria() {
        val db = getWritableDatabase()

        val cliente = Cliente("Teste12","45576867","963741852","Teste9@hotmail.com")
        insereCliente(db, cliente)

        val mercadoria = Mercadoria("Teste11",56.65,53.57, cliente.id)
        insereMercadoria(db, mercadoria)

        val cursor = TabelaBDMercadoria(db).query(
            TabelaBDMercadoria.TODAS_COLUNAS,
            "${BaseColumns._ID}=?",
            arrayOf("${mercadoria.id}"),
            null,
            null,
            null
        )

        assertEquals(1, cursor.count)
        assertTrue(cursor.moveToNext())

        val mercadoriaBD = Mercadoria.fromCursor(cursor)

        assertEquals(mercadoria, mercadoriaBD)

        db.close()
    }

    @Test
    fun consegueLerMotorista() {
        val db = getWritableDatabase()

        val cliente = Cliente("Teste12","45576867","963741852","Teste9@hotmail.com")
        insereCliente(db, cliente)

        val motorista = Motorista("Teste11","23051999","Rua Camoes","34565467","963753741","Teste7@gmail.com")
        insereMotorista(db, motorista)

        val cursor = TabelaBDMotorista(db).query(
            TabelaBDMotorista.TODAS_COLUNAS,
            "${BaseColumns._ID}=?",
            arrayOf("${motorista.id}"),
            null,
            null,
            null
        )

        assertEquals(1, cursor.count)
        assertTrue(cursor.moveToNext())

        val motoristaBD = Motorista.fromCursor(cursor)

        assertEquals(motorista, motoristaBD)

        db.close()
    }

    @Test
    fun consegueLerViagem() {
        val db = getWritableDatabase()

        val cliente = Cliente("Teste12","45576867","963741852","Teste9@hotmail.com")
        insereCliente(db, cliente)

        val viagem = Viagem("Teste15")
        insereViagem(db, viagem)

        val cursor = TabelaBDViagem(db).query(
            TabelaBDViagem.TODAS_COLUNAS,
            "${BaseColumns._ID}=?",
            arrayOf("${viagem.id}"),
            null,
            null,
            null
        )

        assertEquals(1, cursor.count)
        assertTrue(cursor.moveToNext())

        val viagemBD = Viagem.fromCursor(cursor)

        assertEquals(viagem, viagemBD)

        db.close()
    }

}