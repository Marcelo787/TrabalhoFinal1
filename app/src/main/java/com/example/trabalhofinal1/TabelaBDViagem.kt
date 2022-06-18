package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDViagem (db: SQLiteDatabase) : TabelaBD(db, NOME){
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$CAMPO_NOME TEXT NOT NULL," +
                "${CAMPO_MERCADORIA_VIAGEM_ID} INTEGER NOT NULL, FOREIGN KEY (${CAMPO_MERCADORIA_VIAGEM_ID}) REFERENCES ${TabelaBDMercadoriaViagem.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT),"+
                "${CAMPO_VIAGEM_MOTORISTA_ID} INTEGER NOT NULL, FOREIGN KEY (${CAMPO_VIAGEM_MOTORISTA_ID}) REFERENCES ${TabelaBDViagemMotorista.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT),"+
                "${CAMPO_PARTIDA_ID} INTEGER NOT NULL, FOREIGN KEY (${CAMPO_PARTIDA_ID}) REFERENCES ${TabelaBDPartida.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT),"+
                "${CAMPO_CHEGADA_ID} INTEGER NOT NULL, FOREIGN KEY (${CAMPO_CHEGADA_ID}) REFERENCES ${TabelaBDChegada.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT),"+
                "${CAMPO_SERVICOS_ID} INTEGER NOT NULL, FOREIGN KEY (${CAMPO_SERVICOS_ID}) REFERENCES ${TabelaBDServicos.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object {
        const val NOME = "viagem"
        const val CAMPO_NOME = "nomeViagem"
        const val CAMPO_MERCADORIA_VIAGEM_ID = "Mercadoria_ViagemID"
        const val CAMPO_VIAGEM_MOTORISTA_ID = "Viagem_MotoristaID"
        const val CAMPO_PARTIDA_ID = "PartidaID"
        const val CAMPO_CHEGADA_ID = "ChegadaID"
        const val CAMPO_SERVICOS_ID = "ServicosID"
    }
}