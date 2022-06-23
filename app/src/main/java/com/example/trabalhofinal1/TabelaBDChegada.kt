package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDChegada (db: SQLiteDatabase) : TabelaBD(db, NOME){
    override fun cria() {
        db.execSQL(
            "CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " $CAMPO_LOCAL_ENTREGA TEXT NOT NULL," +
                    " $CAMPO_DATA_CHEGADA TEXT NOT NULL)"
        )
    }

    companion object {
        const val NOME = "chegada"
        const val CAMPO_LOCAL_ENTREGA = "localChegada"
        const val CAMPO_DATA_CHEGADA = "dataChegada"

        val TODAS_COLUNAS = arrayOf(CAMPO_LOCAL_ENTREGA,CAMPO_DATA_CHEGADA)
    }
}