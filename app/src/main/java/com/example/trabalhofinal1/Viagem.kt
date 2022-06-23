package com.example.trabalhofinal1

import android.content.ContentValues

data class Viagem(

    var nome: String,
    var id: Long = 1

) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDViagem.CAMPO_NOME,nome)

        return valores
    }
}