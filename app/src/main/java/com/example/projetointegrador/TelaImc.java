package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaImc extends AppCompatActivity {


    private EditText pesokg;
    private EditText alturacm;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_imc);

        getSupportActionBar().hide();
        IniciarComponentes();


    }

    public void bt_calcularimc(View view) {

        double peso = Double.parseDouble(pesokg.getText().toString());
        double altura = Double.parseDouble(alturacm.getText().toString());

        /**IMC = PESO/(ALTURA*ALTURA) **/

        double imc = peso / (altura * altura);

        if (imc >= 18.5 && imc <= 29.99) {

            resultado.setText("Peso Normal, IMC = " + imc);
        } else if (imc >= 25 && imc <= 29.99) {
            resultado.setText("Acima do Peso, IMC = " + imc);
        } else if (imc >= 30 && imc <= 34.99) {
            resultado.setText("Obesidade I, IMC = " + imc);
        } else if (imc >= 35 && imc <= 39.99) {
            resultado.setText("Obesidade II (severa), IMC = " + imc);
        } else if (imc >= 40) {
            resultado.setText("Obesidade III (morbida), IMC = " + imc);
        }
    }

    private void IniciarComponentes() {
        pesokg = findViewById(R.id.pesokg);
        alturacm = findViewById(R.id.alturacm);
        resultado = findViewById(R.id.resultado);

    }
}