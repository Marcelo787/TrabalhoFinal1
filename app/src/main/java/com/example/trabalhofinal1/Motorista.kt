package com.example.trabalhofinal1

data class Motorista(
    var nome: String,
    var dataNascimento: String,
    var morada: String,
    var cc: String,
    var telemovel: String,
    var email: String,
    var id: Long = -1
) {
}