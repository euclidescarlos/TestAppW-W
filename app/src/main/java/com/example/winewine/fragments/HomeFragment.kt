package com.example.winewine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.winewine.R
import com.example.winewine.adapter.VinhoAdapter
import com.example.winewine.model.Carrinho
import com.example.winewine.model.Vinho
import com.example.winewine.utils.HorizontalSpaceItemDecoration

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val ofertas = listOf(
            Vinho(1, "Vinho Reservado", 10, 89.90, R.drawable.reservado),
            Vinho(2, "Vinho Malbec", 15, 75.50, R.drawable.vinho_tinto_malbec_argentino),
            Vinho(3, "Espumante Brut", 8, 120.00, R.drawable.espumante_brut),
            Vinho(4, "Vinho Rosé", 12, 95.00, R.drawable.vinho_rose)
        )

        val maisVendidos = listOf(
            Vinho(5, "Tinto Seco", 25, 55.00, R.drawable.vinho_tinto_seco),
            Vinho(6, "Branco Suave", 18, 65.00, R.drawable.vinho_branco_suave)
        )

        view.findViewById<RecyclerView>(R.id.rvOfertas).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = VinhoAdapter(ofertas) {
                Carrinho.adicionar(it)
                Toast.makeText(context, "${it.nome} adicionado ao carrinho", Toast.LENGTH_SHORT).show()
            }
            addItemDecoration(HorizontalSpaceItemDecoration(8))
        }

        view.findViewById<RecyclerView>(R.id.rvMaisVendidos).apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = VinhoAdapter(maisVendidos) {
                Carrinho.adicionar(it)
                Toast.makeText(context, "${it.nome} adicionado ao carrinho", Toast.LENGTH_SHORT).show()
            }
            addItemDecoration(HorizontalSpaceItemDecoration(8))
        }

        return view
    }
}
