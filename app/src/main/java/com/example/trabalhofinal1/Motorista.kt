package com.example.trabalhofinal1

import android.content.ContentValues

data class Motorista(
    var nome: String,
    var dataNascimento: String,
    var morada: String,
    var cc: String,
    var telemovel: String,
    var email: String,
    var id: Long = -1
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDMotorista.CAMPO_NOME, nome)
        valores.put(TabelaBDMotorista.CAMPO_DATA_NASCIMENTO, dataNascimento )
        valores.put(TabelaBDMotorista.CAMPO_MORADA, morada)
        valores.put(TabelaBDMotorista.CAMPO_CC, cc)
        valores.put(TabelaBDMotorista.CAMPO_TELEMOVEL, telemovel)
        valores.put(TabelaBDMotorista.CAMPO_EMAIL, email)

        return valores
    }
}