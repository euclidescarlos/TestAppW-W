package com.example.winewine.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.winewine.R
import com.example.winewine.model.Vinho

class CarrinhoAdapter(
    private val listaVinhos: MutableList<Vinho>,
    private val onRemoverClick: (Vinho) -> Unit,
    private val onTotalChanged: (Double) -> Unit
) : RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrinhoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carrinho, parent, false)
        return CarrinhoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarrinhoViewHolder, position: Int) {
        val vinho = listaVinhos[position]
        holder.bind(vinho)
    }

    override fun getItemCount(): Int = listaVinhos.size

    inner class CarrinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgVinho: ImageView = itemView.findViewById(R.id.imgVinhoCarrinho)
        private val txtNome: TextView = itemView.findViewById(R.id.txtNomeVinhoCarrinho)
        private val txtPreco: TextView = itemView.findViewById(R.id.txtPrecoVinhoCarrinho)
        private val btnRemover: ImageButton = itemView.findViewById(R.id.btnRemover)

        fun bind(vinho: Vinho) {
            imgVinho.setImageResource(vinho.imagemResId)
            txtNome.text = vinho.nome
            txtPreco.text = "R$ %.2f".format(vinho.preco)

            btnRemover.setOnClickListener {
                onRemoverClick(vinho)
                onTotalChanged(calcularTotal())
            }
        }
    }

    private fun calcularTotal(): Double {
        return listaVinhos.sumOf { it.preco }
    }
}