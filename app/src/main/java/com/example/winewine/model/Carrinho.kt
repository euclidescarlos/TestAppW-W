package com.example.winewine.model

object Carrinho {
    val vinhos = mutableListOf<Vinho>()

    fun adicionar(vinho: Vinho) {
        vinhos.add(vinho)
    }

    fun remover(vinho: Vinho) {
        vinhos.remove(vinho)
    }

    fun limpar() {
        vinhos.clear()
    }
}