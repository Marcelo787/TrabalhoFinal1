package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDServicos (db: SQLiteDatabase) : TabelaBD(db, NOME){
    override fun cria() {
        db.execSQL(
            "CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " $CAMPO_SERVICOS TEXT NOT NULL)"
        )
    }

    companion object {
        const val NOME = "servicos"
        const val CAMPO_SERVICOS = "tipoServicos"
    }
}