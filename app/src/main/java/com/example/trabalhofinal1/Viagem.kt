package com.example.trabalhofinal1

import android.content.ContentValues

data class Viagem(
    var partidaId: Long,
    var chegadaId: Long,
    var servicoId: Long,
    var mercadoriaId: Long,
    var motoristaId: Long,
    var viagemMotoristaId: Long,
    var mercadoriaViagemId: Long,
    var id: Long = -1
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDViagem.CAMPO_PARTIDA_ID, partidaId)
        valores.put(TabelaBDViagem.CAMPO_CHEGADA_ID, chegadaId)
        valores.put(TabelaBDViagem.CAMPO_SERVICOS_ID, servicoId)
        valores.put(TabelaBDViagem.CAMPO_VIAGEM_MOTORISTA_ID, viagemMotoristaId)
        valores.put(TabelaBDViagem.CAMPO_MERCADORIA_VIAGEM_ID, mercadoriaViagemId)

        return valores
    }
}