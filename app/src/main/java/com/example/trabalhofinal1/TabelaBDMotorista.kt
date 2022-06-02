package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDMotorista (val db: SQLiteDatabase) {
    fun cria() {
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " $CAMPO_NOME TEXT NOT NULL," +
                " $CAMPO_MORADA TEXT NOT NULL,"+
                " $CAMPO_NASCIMENTO DATE NOT NULL," +
                " $CAMPO_CC TEXT NOT NULL," +
                " $CAMPO_TELEMOVEL TEXT NOT NULL," +
                " $CAMPO_EMAIL TEXT NOT NULL)")
    }

    companion object {
        const val NOME = "motorista"
        const val CAMPO_NOME = "nome"
        const val CAMPO_MORADA = "morada"
        const val CAMPO_NASCIMENTO = "dataNascimento"
        const val CAMPO_CC = "BI"
        const val CAMPO_TELEMOVEL = "telemovel"
        const val CAMPO_EMAIL = "email"
    }
}