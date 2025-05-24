package com.example.winewine

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.widget.Toast
import android.content.Intent
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            }
        // Aqui pegamos o TextView que será o "botão" de esqueceu a senha
        val esqueceuSenha = findViewById<TextView>(R.id.textEsqueceuSenha)

        // Configuramos o clique para mostrar um Toast (pode trocar isso futuramente)
        esqueceuSenha.setOnClickListener {
            Toast.makeText(this, "Função ainda não implementada.", Toast.LENGTH_SHORT).show()
            }
            // Aqui pegamos o TextView que será o "botão" de esqueceu a senha
            val cadastrese = findViewById<TextView>(R.id.textCadastrese)

            // Configuramos o clique para mostrar um Toast (pode trocar isso futuramente)
            cadastrese.setOnClickListener {
                Toast.makeText(this, "Função ainda não implementada.", Toast.LENGTH_SHORT).show()

            }

        val loginButton = findViewById<Button>(R.id.buttonLogin)
        loginButton.setOnClickListener {
            val intent = Intent(this, mainScreen::class.java)
            startActivity(intent)
        }

    }
}