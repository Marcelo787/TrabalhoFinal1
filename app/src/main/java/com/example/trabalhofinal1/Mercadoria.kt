package com.example.trabalhofinal1

data class Mercadoria(
    var tipoMercadoria: String,
    var peso: String,
    var dimensoes: String,
    var clienteId: Long,
    var id: Long = -1
) {
}