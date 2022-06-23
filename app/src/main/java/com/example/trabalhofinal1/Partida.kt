package com.example.trabalhofinal1

import android.content.ContentValues

data class Partida(
    var localRecolha: String,
    var dataPartida: String,
    var id: Long = 1
) {

    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDPartida.CAMPO_LOCAL_RECOLHA, localRecolha)
        valores.put(TabelaBDPartida.CAMPO_DATA_PARTIDA, dataPartida)

        return valores
    }
}