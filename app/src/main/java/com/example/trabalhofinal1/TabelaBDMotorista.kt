package com.example.trabalhofinal1

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDMotorista (db: SQLiteDatabase) : TabelaBD(db, NOME){
    override fun cria() {
        db.execSQL(
            "CREATE TABLE $nome (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " $CAMPO_NOME TEXT NOT NULL," +
                    " $CAMPO_MORADA TEXT NOT NULL," +
                    " $CAMPO_DATA_NASCIMENTO LONG NOT NULL," +
                    " $CAMPO_CC TEXT NOT NULL," +
                    " $CAMPO_TELEMOVEL TEXT NOT NULL," +
                    " $CAMPO_EMAIL TEXT NOT NULL," +
                    "$CAMPO_VIAGEM_MOTORISTA_ID INTEGER NOT NULL, FOREIGN KEY ($CAMPO_VIAGEM_MOTORISTA_ID) REFERENCES ${TabelaBDMercadoriaViagem.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)"
        )
    }

    companion object {
        const val NOME = "motorista"
        const val CAMPO_NOME = "nome"
        const val CAMPO_MORADA = "morada"
        const val CAMPO_DATA_NASCIMENTO = "dataNascimento"
        const val CAMPO_CC = "BI"
        const val CAMPO_TELEMOVEL = "telemovel"
        const val CAMPO_EMAIL = "email"
        const val CAMPO_VIAGEM_MOTORISTA_ID = "ViagemMotorista"
    }
}