package com.example.trabalhofinal1

import android.content.ContentValues
import android.icu.number.IntegerWidth

data class Mercadoria(
    var tipoMercadoria: String,
    var peso: Double,
    var dimensoes: Double,
    var clienteId: Long,
    var id: Long = 1
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDMercadoria.CAMPO_TIPO_MERCADORIA, tipoMercadoria)
        valores.put(TabelaBDMercadoria.CAMPO_PESO, peso)
        valores.put(TabelaBDMercadoria.CAMPO_DIMENSOES, dimensoes)
        valores.put(TabelaBDMercadoria.CAMPO_CLIENTE_ID, clienteId)

        return valores
    }
}