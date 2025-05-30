package com.example.winewine.adapter

import android.content.res.Resources
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.winewine.R
import com.example.winewine.model.Vinho

class VinhoAdapter(
    private val listaVinhos: List<Vinho>,
    private val onAddClick: (Vinho) -> Unit
) : RecyclerView.Adapter<VinhoAdapter.VinhoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VinhoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vinho, parent, false)
        return VinhoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VinhoViewHolder, position: Int) {
        val vinho = listaVinhos[position]
        holder.bind(vinho)
    }

    override fun getItemCount(): Int = listaVinhos.size

    inner class VinhoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nomeVinho: TextView = itemView.findViewById(R.id.txtNomeVinho)
        private val precoVinho: TextView = itemView.findViewById(R.id.txtPreco)
        private val imagemVinho: ImageView = itemView.findViewById(R.id.imgVinho)
        private val botaoAdicionar: ImageButton = itemView.findViewById(R.id.btnAdicionar)

        fun bind(vinho: Vinho) {
            nomeVinho.text = vinho.nome
            precoVinho.text = "R$ %.2f".format(vinho.preco)

            try {
                if (vinho.imagemResId != 0) {
                    imagemVinho.setImageResource(vinho.imagemResId)
                } else {
                    imagemVinho.setImageResource(R.drawable.placeholder_vinho)
                }
            } catch (e: Resources.NotFoundException) {
                imagemVinho.setImageResource(R.drawable.placeholder_vinho)
                Log.e("VinhoAdapter", "Imagem não encontrada: ${vinho.imagemResId}")
            }

            botaoAdicionar.setOnClickListener {
                onAddClick(vinho)
            }
        }
    }
}