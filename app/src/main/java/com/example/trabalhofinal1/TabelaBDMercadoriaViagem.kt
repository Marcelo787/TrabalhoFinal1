package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDMercadoriaViagem (db: SQLiteDatabase) : TabelaBD(db, NOME){
    override fun cria() {
        db.execSQL(
            "CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$CAMPO_MERCADORIA_ID INTEGER NOT NULL, FOREIGN KEY (${TabelaBDMercadoriaViagem.CAMPO_MERCADORIA_ID}) REFERENCES ${TabelaBDMercadoria.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)," +
                    "$CAMPO_VIAGEM_ID INTEGER NOT NULL, FOREIGN KEY (${TabelaBDMercadoriaViagem.CAMPO_VIAGEM_ID}) REFERENCES ${TabelaBDViagem.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)"
        )
    }

    companion object {
        const val NOME = "viagem"
        const val CAMPO_MERCADORIA_ID = "MercadoriaID"
        const val CAMPO_VIAGEM_ID = "ViagemID"
    }
}