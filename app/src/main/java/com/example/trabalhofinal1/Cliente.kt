package com.example.trabalhofinal1

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import java.io.Serializable

data class Cliente(
    var nome: String,
    var cc: String,
    var telemovel: String,
    var email: String,
    var id: Long = 1
): Serializable {
    fun toContentValues() : ContentValues{
        val valores = ContentValues()
        valores.put(TabelaBDCliente.CAMPO_NOME, nome)
        valores.put(TabelaBDCliente.CAMPO_CC, cc)
        valores.put(TabelaBDCliente.CAMPO_TELEMOVEL, telemovel)
        valores.put(TabelaBDCliente.CAMPO_EMAIL, email)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Cliente {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posNome = cursor.getColumnIndex(TabelaBDCliente.CAMPO_NOME)
            val posCC = cursor.getColumnIndex(TabelaBDCliente.CAMPO_CC)
            val posTelemovel = cursor.getColumnIndex(TabelaBDCliente.CAMPO_TELEMOVEL)
            val posEmail = cursor.getColumnIndex(TabelaBDCliente.CAMPO_EMAIL)

            val id = cursor.getLong(posId)
            val nome = cursor.getString(posNome)
            val cc = cursor.getString(posCC)
            val telemovel = cursor.getString(posTelemovel)
            val email = cursor.getString(posEmail)


            return Cliente(nome, cc, telemovel, email, id)
        }
    }
}