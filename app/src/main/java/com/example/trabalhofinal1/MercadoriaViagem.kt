package com.example.trabalhofinal1

import android.content.ContentValues

data class MercadoriaViagem(
    var mercadoriaId: Long,
    var viagemId: Long,
    var id: Long = -1,
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDMercadoriaViagem.CAMPO_MERCADORIA_ID, mercadoriaId)
        valores.put(TabelaBDMercadoriaViagem.CAMPO_VIAGEM_ID, viagemId)

        return valores
    }
}