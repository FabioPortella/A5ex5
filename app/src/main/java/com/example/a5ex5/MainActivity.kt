package com.example.a5ex5

import android.content.Context
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
    lateinit var btnPar: Button
    lateinit var btnImpar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialização do Shared Preferences
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
        score = sharedPref.getInt("SCORE", 0)


        // iniciando componentes da UI
        txtResultado = findViewById(R.id.txtResultado)
        btnNovo = findViewById(R.id.btnNovo)
        btnPar = findViewById(R.id.btnPar)
        btnImpar = findViewById(R.id.btnImpar)

        // dispara novoJogo na inicialização
        novoJogo()
    }

    private fun novoJogo(){
        txtResultado.text = "Par ou Impar"
        resultado = Random.nextInt(from = 0, until = 10)
        btnNovo.visibility = View.INVISIBLE
        btnImpar.visibility = View.VISIBLE
        btnPar.visibility = View.VISIBLE
    }

    fun novoJogo(view: View) {
        novoJogo()
    }

    // Função alterada do código original
    // ao clicar no botao PAR ou IMPAR estes botões vicam invisiveis,
    // para evitar do usuário clicar novamente e não fazer nada.
    // Ao clicar no botão NOVO JOGO, este botão fica invisivel e o PAR e IMPAR visiveis
    fun jogada(view: View){
        if(resultado % 2 == view.tag.toString().toInt())
             {
                score++
                getPreferences(MODE_PRIVATE).edit().putInt("SCORE", score).commit()
                btnImpar.visibility = View.INVISIBLE
                btnPar.visibility = View.INVISIBLE
                title = "Score: $score  -  Ganhou"
            }
        else
        {
            btnImpar.visibility = View.INVISIBLE
            btnPar.visibility = View.INVISIBLE
            title = "Score: $score  -  Perdeu"
        }

        txtResultado.text = "$resultado"
        btnNovo.visibility = View.VISIBLE
    }
}