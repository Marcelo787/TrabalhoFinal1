package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDMercadorias (val db: SQLiteDatabase) {
    fun cria() {
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " $CAMPO_NOME TEXT NOT NULL," +
                " $CAMPO_TIPO TEXT NOT NULL,"+
                " $CAMPO_PESO TEXT NOT NULL," +
                " $CAMPO_QUANTIDADE TEXT NOT NULL," +
                " $CAMPO_VOLUME TEXT NOT NULL)")
    }

    companion object {
        const val NOME = "mercadorias"
        const val CAMPO_NOME = "nomeMercadoria"
        const val CAMPO_TIPO = "tipoMercadoria"
        const val CAMPO_PESO = "peso"
        const val CAMPO_QUANTIDADE = "quantidade"
        const val CAMPO_VOLUME = "volume"
    }
}