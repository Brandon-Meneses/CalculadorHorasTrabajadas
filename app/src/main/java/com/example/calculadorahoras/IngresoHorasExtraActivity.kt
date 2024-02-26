package com.example.calculadorahoras

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class IngresoHorasExtraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso_horas_extra)

        val cantDias: Int = intent.getIntExtra("dias", 0)
        val listaDias = mutableListOf<String>()
        for (i in 1..cantDias) {
            listaDias.add("Día $i")
        }

        val spinner = findViewById<Spinner>(R.id.spnDias)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaDias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        val horasPorDia = HashMap<String, Pair<String, String>>()
        val etTimeFirst = findViewById<EditText>(R.id.etTimeFirst)
        val etTimeSecond = findViewById<EditText>(R.id.etTimeSecond)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val diaSeleccionado = listaDias[position]
                val horasParaDia = horasPorDia[diaSeleccionado]
                if (horasParaDia != null) {
                    etTimeFirst.setText(horasParaDia.first)
                    etTimeSecond.setText(horasParaDia.second)
                } else {
                    etTimeFirst.text = null
                    etTimeSecond.text = null
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        etTimeFirst.addTextChangedListener(createTextWatcher(etTimeFirst, horasPorDia))
        etTimeSecond.addTextChangedListener(createTextWatcher(etTimeSecond, horasPorDia))
    }

    private fun createTextWatcher(editText: EditText, horasPorDia: HashMap<String, Pair<String, String>>): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val diaSeleccionado = (findViewById<Spinner>(R.id.spnDias)).selectedItem as String
                val horas = horasPorDia[diaSeleccionado] ?: Pair("", "")
                horasPorDia[diaSeleccionado] = if (editText.id == R.id.etTimeFirst) Pair(s.toString(), horas.second) else Pair(horas.first, s.toString())
            }
        }
    }
}


