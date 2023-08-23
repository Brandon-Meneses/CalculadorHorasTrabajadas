package com.example.calculadorahoras

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var tvResultado: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etHoras = findViewById<EditText>(R.id.etHoras)
        val etMinutos = findViewById<EditText>(R.id.etMinutos)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        fun showToast(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        btnCalcular.setOnClickListener {
            val horasText = etHoras.text.toString()
            val minutosText = etMinutos.text.toString()

            if (horasText.isEmpty() || minutosText.isEmpty()) {
                showToast("Por favor, llena ambos campos.")
                tvResultado.text=("")
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
                return@setOnClickListener
            }
            val horasDescanso = etHoras.text.toString().toIntOrNull() ?: 0
            val minutosDescanso = etMinutos.text.toString().toIntOrNull() ?: 0
            val minutosPorDia = 3 * 60 + 50 // 3 horas y 50 minutos en minutos

            val totalMinutosDescanso = horasDescanso * 60 + minutosDescanso
            val diasCompletos = totalMinutosDescanso / minutosPorDia
            val minutosRestantes = totalMinutosDescanso % minutosPorDia

            val horasRestantes = minutosRestantes / 60
            val minutosFinales = minutosRestantes % 60

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)

            val resultado = "$horasDescanso horas y $minutosDescanso minutos de descanso equivalen a:\n" +
                    "$diasCompletos días, $horasRestantes horas y $minutosFinales minutos."

            tvResultado.text = resultado
            }

        }





}