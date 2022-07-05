package com.example.trabalhofinal1

import android.content.ContentValues
import android.database.Cursor
import android.icu.number.IntegerWidth
import android.provider.BaseColumns
import java.io.Serializable

data class Mercadoria(
    var tipoMercadoria: String,
    var peso: Double,
    var dimensoes: Double,
    var clienteId: Long,
    var id: Long = 1
): Serializable {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDMercadoria.CAMPO_TIPO_MERCADORIA, tipoMercadoria)
        valores.put(TabelaBDMercadoria.CAMPO_PESO, peso)
        valores.put(TabelaBDMercadoria.CAMPO_DIMENSOES, dimensoes)
        valores.put(TabelaBDMercadoria.CAMPO_CLIENTE_ID, clienteId)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Mercadoria {
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val postipoMercadoria = cursor.getColumnIndex(TabelaBDMercadoria.CAMPO_TIPO_MERCADORIA)
            val posPeso = cursor.getColumnIndex(TabelaBDMercadoria.CAMPO_PESO)
            val posDimensoes = cursor.getColumnIndex(TabelaBDMercadoria.CAMPO_DIMENSOES)
            val idCliente = cursor.getColumnIndex(TabelaBDMercadoria.CAMPO_CLIENTE_ID)

            val id = cursor.getLong(posId)
            val tipoMercadoria = cursor.getString(postipoMercadoria)
            val peso = cursor.getDouble(posPeso)
            val dimensoes = cursor.getDouble(posDimensoes)
            val clienteId = cursor.getLong(idCliente)


            return Mercadoria(tipoMercadoria, peso, dimensoes, clienteId, id)
        }
    }
}