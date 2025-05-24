package com.example.winewine // pacote do projeto, precisa bater com o AndroidManifest

import android.content.Intent // import necessário pra navegar entre activities
import android.os.Bundle
import android.widget.Button // pra conseguir acessar o botão do layout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge() // deixa a activity desenhar até a borda da tela

        setContentView(R.layout.activity_inicial) // aqui é onde você "liga" o XML da tela

        // Isso aplica padding automático pra status bar e barra de navegação
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Pegando o botão pelo ID (button2 é o botão "Fazer login" do seu XML)
        val loginButton = findViewById<Button>(R.id.button2)

        // Quando clicar no botão, ele vai abrir a LoginActivity
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java) // cria a intenção de abrir LoginActivity
            startActivity(intent) // inicia a nova activity
        }
    }
}