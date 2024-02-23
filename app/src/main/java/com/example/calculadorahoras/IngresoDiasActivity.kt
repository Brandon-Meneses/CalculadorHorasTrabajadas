package com.example.calculadorahoras

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class IngresoDiasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_dias)
        var etDias = findViewById<EditText>(R.id.etCantidadDias)
        intent.putExtra("dias", etDias.text.toString())



    }

}