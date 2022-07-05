package com.example.trabalhofinal1

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import java.io.Serializable

data class Viagem(

    var nome: String,
    var id: Long = 1

): Serializable {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDViagem.CAMPO_NOME,nome)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Viagem {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posNome = cursor.getColumnIndex(TabelaBDViagem.CAMPO_NOME)

            val id = cursor.getLong(posId)
            val nome = cursor.getString(posNome)

            return Viagem(nome, id)
        }
    }
}