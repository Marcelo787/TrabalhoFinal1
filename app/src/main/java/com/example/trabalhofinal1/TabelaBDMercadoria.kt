package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDMercadoria (db: SQLiteDatabase) : TabelaBD(db, NOME){
    override fun cria() {
        db.execSQL("CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " $CAMPO_TIPO_MERCADORIA TEXT NOT NULL,"+
                " $CAMPO_PESO INTEGER NOT NULL," +
                " $CAMPO_DIMENSOES INTEGER NOT NULL," +
                "$CAMPO_CLIENTE_ID INTEGER NOT NULL, FOREIGN KEY ($CAMPO_CLIENTE_ID) REFERENCES ${TabelaBDCliente.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object {
        const val NOME = "mercadorias"
        const val CAMPO_TIPO_MERCADORIA = "tipoMercadoria"
        const val CAMPO_PESO = "peso"
        const val CAMPO_DIMENSOES = "dimensoes"
        const val CAMPO_CLIENTE_ID = "clienteID"

        val TODAS_COLUNAS = arrayOf(
            CAMPO_TIPO_MERCADORIA,CAMPO_PESO,CAMPO_DIMENSOES,CAMPO_CLIENTE_ID)
    }
}