package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDPartida (db: SQLiteDatabase) : TabelaBD(db, NOME){
    override fun cria() {
        db.execSQL(
            "CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " $CAMPO_LOCAL_RECOLHA TEXT NOT NULL," +
                    " $CAMPO_DATA_PARTIDA TEXT NOT NULL)"
        )
    }

    companion object {
        const val NOME = "partida"
        const val CAMPO_LOCAL_RECOLHA = "localPartida"
        const val CAMPO_DATA_PARTIDA = "dataPartida"
    }
}