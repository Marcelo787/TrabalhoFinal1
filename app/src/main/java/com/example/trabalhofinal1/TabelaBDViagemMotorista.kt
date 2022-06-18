package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDViagemMotorista (db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL(
            "CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$CAMPO_VIAGEM_ID INTEGER NOT NULL, FOREIGN KEY (${TabelaBDViagemMotorista.CAMPO_VIAGEM_ID}) REFERENCES ${TabelaBDViagem.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)," +
                    "$CAMPO_MOTORISTA_ID INTEGER NOT NULL, FOREIGN KEY (${TabelaBDViagemMotorista.CAMPO_MOTORISTA_ID}) REFERENCES ${TabelaBDMotorista.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)"
        )
    }

    companion object {
        const val NOME = "viagem"
        const val CAMPO_VIAGEM_ID = "ViagemID"
        const val CAMPO_MOTORISTA_ID = "MotoristaID"
    }
}