package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btCalcular(view: View){

        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()
        val validaCampos = validarCampos(precoAlcool, precoGasolina)
        if(validaCampos){
            calcularPreco(precoAlcool, precoGasolina)
        }else{
            text_resultado.setText(("Preencha os preços primeiro!"))
        }



    }
        fun validarCampos(precoAlcool: String, precoGasolina: String) : Boolean{
            var camposValidados: Boolean = true

            if(precoAlcool == null || precoAlcool.equals("")){
                camposValidados = false
            }else if(precoGasolina == null || precoGasolina.equals("")){
                camposValidados = false
            }
            return camposValidados
        }


        fun calcularPreco(precoAlcool: String, precoGasolina: String){
            val valorAlcool = precoAlcool.toDouble()
            val valorGasolina = precoGasolina.toDouble()

            val resultadoPreco = valorAlcool/ valorGasolina

            if(resultadoPreco>=0.7){
                text_resultado.setText("Melhor utilizar gasolina!")
            }else{
                text_resultado.setText("Melhor utilizar o alcool")
            }

        }
}