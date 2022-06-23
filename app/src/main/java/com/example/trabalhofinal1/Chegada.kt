package com.example.trabalhofinal1

import android.content.ContentValues

data class Chegada(
    var localEntrega: String,
    var dataChegada: String,
    var id: Long = 1
) {

    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDChegada.CAMPO_LOCAL_ENTREGA, localEntrega)
        valores.put(TabelaBDChegada.CAMPO_DATA_CHEGADA, dataChegada)

        return valores
    }
}