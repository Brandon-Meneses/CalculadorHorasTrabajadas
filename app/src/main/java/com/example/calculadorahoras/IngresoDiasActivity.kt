package com.example.calculadorahoras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class IngresoDiasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_dias)


        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        btnIngresar.setOnClickListener {
            val etDias = findViewById<EditText>(R.id.etCantidadDias)
            val intent = Intent(this, IngresoHorasExtraActivity::class.java)
            intent.putExtra("dias", Integer.parseInt(etDias.text.toString()))
            startActivity(intent)
        }
    }

}