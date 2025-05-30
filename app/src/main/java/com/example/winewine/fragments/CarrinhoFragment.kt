package com.example.winewine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.winewine.R
import com.example.winewine.adapter.CarrinhoAdapter
import com.example.winewine.model.Carrinho
import com.example.winewine.model.Vinho
import java.text.NumberFormat
import java.util.Locale
import android.widget.Toast

class CarrinhoFragment : Fragment() {
    private lateinit var adapter: CarrinhoAdapter
    private lateinit var txtTotal: TextView
    private lateinit var btnFinalizar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_carrinho, container, false)

        txtTotal = view.findViewById(R.id.txtTotal)
        btnFinalizar = view.findViewById(R.id.btnFinalizar)

        setupRecyclerView(view)
        setupListeners()
        atualizarTotal()

        return view
    }

    private fun setupRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvCarrinho)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = CarrinhoAdapter(
            Carrinho.vinhos,
            onRemoverClick = { vinho ->
                Carrinho.remover(vinho)
                adapter.notifyDataSetChanged()
            },
            onTotalChanged = { total ->
                atualizarTotal()
            }
        )

        recyclerView.adapter = adapter
    }

    private fun setupListeners() {
        btnFinalizar.setOnClickListener {
            if (Carrinho.vinhos.isNotEmpty()) {
                Toast.makeText(requireContext(), "Compra finalizada!", Toast.LENGTH_SHORT).show()
                Carrinho.limpar()
                adapter.notifyDataSetChanged()
                atualizarTotal()
            } else {
                Toast.makeText(requireContext(), "Carrinho vazio!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun atualizarTotal() {
        val total = Carrinho.vinhos.sumOf { it.preco }
        txtTotal.text = "Total: ${formatarMoeda(total)}"
    }

    private fun formatarMoeda(valor: Double): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(valor)
    }
}