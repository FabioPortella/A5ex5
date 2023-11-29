package com.example.a5ex5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var resultado = 0
    private var score = 0
    lateinit var txtResultado: TextView
    lateinit var btnNovo: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // iniciando componentes da UI
        txtResultado = findViewById(R.id.txtResultado)
        btnNovo = findViewById(R.id.btnNovo)

        // dispara a funçao na inicialização
        novoJogo()
    }

    private fun novoJogo(){
        txtResultado.text = "Par ou Impar"
        resultado = Random.nextInt(from = 0, until = 10)
        btnNovo.visibility = View.INVISIBLE
    }

    fun novoJogo(view: View) {
        novoJogo()
    }

    fun jogada(view: View){
        if(resultado % 2 == view.tag.toString().toInt())
            if (btnNovo.visibility == View.INVISIBLE)
                score++
        title = "Score: $score"
        txtResultado.text = "$resultado"

        btnNovo.visibility = View.VISIBLE
    }
}