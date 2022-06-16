package com.example.trabalhofinal1

import android.content.ContentValues

data class Viagem(
    var dataPartida: String,
    var dataChegada: String,
    var localPartida: String,
    var localChegada: String,
    var tipoServico: String,
    var mercadoriaId: Long,
    var motoristaId: Long,
    var id: Long = -1
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDViagem.CAMPO_DCHEGADA, dataChegada)
        valores.put(TabelaBDViagem.CAMPO_DPARTIDA, dataPartida)
        valores.put(TabelaBDViagem.CAMPO_LCHEGADA, localChegada)
        valores.put(TabelaBDViagem.CAMPO_LPARTIDA, localPartida)
        valores.put(TabelaBDViagem.CAMPO_TIPO_SERVICO, tipoServico)
        valores.put(TabelaBDViagem.CAMPO_MERCADORIA_ID, mercadoriaId)
        valores.put(TabelaBDViagem.CAMPO_MOTORISTA_ID, motoristaId)

        return valores
    }
}