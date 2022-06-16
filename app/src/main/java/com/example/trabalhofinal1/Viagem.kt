package com.example.trabalhofinal1

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
}