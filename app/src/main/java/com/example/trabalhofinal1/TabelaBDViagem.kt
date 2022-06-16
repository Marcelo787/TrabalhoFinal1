package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDViagem (db: SQLiteDatabase) : TabelaBD(db, NOME){
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " $CAMPO_NOME TEXT NOT NULL," +
                " $CAMPO_DPARTIDA DATE NOT NULL,"+
                " $CAMPO_DCHEGADA DATE NOT NULL," +
                " $CAMPO_LCHEGADA TEXT NOT NULL," +
                " $CAMPO_LPARTIDA TEXT NOT NULL)" +
                "${CAMPO_MERCADORIA_ID} INTEGER NOT NULL, FOREIGN KEY (${CAMPO_MERCADORIA_ID}) REFERENCES ${TabelaBDMercadoria.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT),"+
                "${CAMPO_MOTORISTA_ID} INTEGER NOT NULL, FOREIGN KEY (${CAMPO_MOTORISTA_ID}) REFERENCES ${TabelaBDMotorista.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT),"+
                " $CAMPO_TIPO_SERVICO TEXT NOT NULL)")
    }

    companion object {
        const val NOME = "viagem"
        const val CAMPO_NOME = "nomeViagem"
        const val CAMPO_DPARTIDA = "dataPartida"
        const val CAMPO_DCHEGADA = "dataChegada"
        const val CAMPO_LPARTIDA = "localPartida"
        const val CAMPO_LCHEGADA = "localChegada"
        const val CAMPO_TIPO_SERVICO = "localChegada"
        const val CAMPO_MERCADORIA_ID = "MercadoriaID"
        const val CAMPO_MOTORISTA_ID = "MotoristaID"
    }
}