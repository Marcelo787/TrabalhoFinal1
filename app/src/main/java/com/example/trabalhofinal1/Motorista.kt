package com.example.trabalhofinal1

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Motorista(
    var nome: String,
    var dataNascimento: String,
    var morada: String,
    var cc: String,
    var telemovel: String,
    var email: String,
    var id: Long = 1
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

    companion object {
        fun fromCursor(cursor: Cursor): Motorista {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posNome = cursor.getColumnIndex(TabelaBDMotorista.CAMPO_NOME)
            val posDataNascimento = cursor.getColumnIndex(TabelaBDMotorista.CAMPO_DATA_NASCIMENTO)
            val posMorada = cursor.getColumnIndex(TabelaBDMotorista.CAMPO_MORADA)
            val posCC = cursor.getColumnIndex(TabelaBDMotorista.CAMPO_CC)
            val posTelemovel = cursor.getColumnIndex(TabelaBDMotorista.CAMPO_TELEMOVEL)
            val posEmail = cursor.getColumnIndex(TabelaBDMotorista.CAMPO_EMAIL)

            val id = cursor.getLong(posId)
            val nome = cursor.getString(posNome)
            val dataNascimento = cursor.getString(posDataNascimento)
            val morada = cursor.getString(posMorada)
            val cc = cursor.getString(posCC)
            val telemovel = cursor.getString(posTelemovel)
            val email = cursor.getString(posEmail)

            return Motorista(nome,dataNascimento,morada,cc,telemovel,email, id)
        }
    }
}