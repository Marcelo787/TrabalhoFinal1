package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDViagem (val db: SQLiteDatabase){
    fun cria() {
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " $CAMPO_NOME TEXT NOT NULL," +
                " $CAMPO_DPARTIDA TEXT NOT NULL,"+
                " $CAMPO_DCHEGADA DATE NOT NULL," +
                " $CAMPO_LCHEGADA TEXT NOT NULL," +
                " $CAMPO_LPARTIDA TEXT NOT NULL)")
    }

    companion object {
        const val NOME = "viagem"
        const val CAMPO_NOME = "nomeViagem"
        const val CAMPO_DPARTIDA = "dataPartida"
        const val CAMPO_DCHEGADA = "dataChegada"
        const val CAMPO_LPARTIDA = "localPartida"
        const val CAMPO_LCHEGADA = "localChegada"
    }
}