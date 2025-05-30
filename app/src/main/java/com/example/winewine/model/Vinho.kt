package com.example.winewine.model

data class Vinho(
    val id: Int,
    val nome: String,
    val estoque: Int,
    val preco: Double,
    val imagemResId: Int // Ex: R.drawable.vinho_carreteiro
)