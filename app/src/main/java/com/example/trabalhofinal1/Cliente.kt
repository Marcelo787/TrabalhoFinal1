package com.example.trabalhofinal1

import android.content.ContentValues
import android.provider.BaseColumns

data class Cliente(
    var nome: String,
    var cc: String,
    var telemovel: String,
    var id: Long = -1
) {
    fun toContentValues() : ContentValues{
        val valores = ContentValues()
        valores.put(TabelaBDCliente.CAMPO_NOME, nome)
        valores.put(TabelaBDCliente.CAMPO_CC, cc)
        valores.put(TabelaBDCliente.CAMPO_TELEMOVEL, telemovel)

        return valores
    }
}