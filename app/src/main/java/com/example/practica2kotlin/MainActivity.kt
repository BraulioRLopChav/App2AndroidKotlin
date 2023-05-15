package com.example.practica2kotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var pesoEditText: EditText
    private lateinit var alturaEditText: EditText
    private lateinit var resultadoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pesoEditText = findViewById(R.id.pesoEditText)
        alturaEditText = findViewById(R.id.alturaEditText)
        resultadoTextView = findViewById(R.id.resultadoTextView)
    }

    fun calcularIMC(view: View) {
        val pesoString = pesoEditText.text.toString()
        val alturaString = alturaEditText.text.toString()

        if (pesoString.isEmpty() || alturaString.isEmpty()) {
            Toast.makeText(applicationContext,"Ingresa el Peso y la Altura",Toast.LENGTH_LONG).show()
        } else {
            val peso = pesoString.toFloat()
            val altura = alturaString.toFloat() / 100

            val imc = peso / (altura * altura)
            val df = DecimalFormat("#.##")
            val imcRedondeado = df.format(imc)

            resultadoTextView.text = String.format("Tu IMC es: %s kg/m²", imcRedondeado)
        }
    }

    fun limpiarCampos(view: View) {
        pesoEditText.setText("")
        alturaEditText.setText("")
        resultadoTextView.setText("")
    }

    fun cerrarApp(view: View) {
        finish()
    }
}
