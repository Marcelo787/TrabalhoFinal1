package com.example.trabalhofinal1

import android.content.ContentValues

data class ViagemMotorista(
    var viagemId: Long,
    var motoristaId: Long,
    var id: Long = 1
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDViagemMotorista.CAMPO_VIAGEM_ID, viagemId)
        valores.put(TabelaBDViagemMotorista.CAMPO_MOTORISTA_ID, motoristaId)

        return valores
    }
}