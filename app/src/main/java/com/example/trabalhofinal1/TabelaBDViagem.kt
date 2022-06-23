package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDViagem (db: SQLiteDatabase) : TabelaBD(db, NOME){
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_NOME TEXT NOT NULL)")
    }

    companion object {
        const val NOME = "viagem"
        const val CAMPO_NOME = "NOME"

        val TODAS_COLUNAS = arrayOf(CAMPO_NOME)
    }
}