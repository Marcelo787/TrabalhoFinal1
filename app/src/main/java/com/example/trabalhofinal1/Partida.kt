package com.example.trabalhofinal1

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Partida(
    var localRecolha: String,
    var dataPartida: String,
    var id: Long = 1
) {

    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDPartida.CAMPO_LOCAL_RECOLHA, localRecolha)
        valores.put(TabelaBDPartida.CAMPO_DATA_PARTIDA, dataPartida)
        TabelaBDPartida
        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Partida {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posLocalRecolha = cursor.getColumnIndex(TabelaBDPartida.CAMPO_LOCAL_RECOLHA)
            val posDataPartida = cursor.getColumnIndex(TabelaBDPartida.CAMPO_DATA_PARTIDA)


            val id = cursor.getLong(posId)
            val localRecolha = cursor.getString(posLocalRecolha)
            val dataPartida = cursor.getString(posDataPartida)


            return Partida(localRecolha, dataPartida, id)
        }
    }
}