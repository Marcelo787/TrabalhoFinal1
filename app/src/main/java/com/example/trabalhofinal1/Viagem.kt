package com.example.trabalhofinal1

import android.content.ContentValues

data class Viagem(

    var id: Long = 1

) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        return valores
    }
}