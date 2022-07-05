package com.example.trabalhofinal1

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import java.io.Serializable

data class Chegada(
    var localEntrega: String,
    var dataChegada: String,
    var id: Long = 1
): Serializable {

    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDChegada.CAMPO_LOCAL_ENTREGA, localEntrega)
        valores.put(TabelaBDChegada.CAMPO_DATA_CHEGADA, dataChegada)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Chegada {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posLocalEntrega = cursor.getColumnIndex(TabelaBDChegada.CAMPO_LOCAL_ENTREGA)
            val posDataChegada = cursor.getColumnIndex(TabelaBDChegada.CAMPO_DATA_CHEGADA)


            val id = cursor.getLong(posId)
            val localEntrega = cursor.getString(posLocalEntrega)
            val dataChegada = cursor.getString(posDataChegada)


            return Chegada(localEntrega, dataChegada, id)
        }
    }
}