package com.example.mathmax;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class Potenciacao extends AppCompatActivity {

    private Double base, expoente, resultado;
    private EditText valor1, valor2;
    private TextView resultadov, passos;

    private Button btnCalcular;

    private ImageView btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potenciacao);

        valor1 = findViewById(R.id.editBase);
        valor2 = findViewById(R.id.editExpoente);
        resultadov = findViewById(R.id.editResultado);
        passos = findViewById(R.id.txtViewPassos);
        btnCalcular = findViewById(R.id.btnCalcular);
        btBack = findViewById(R.id.btBackPotenciacao);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valor1.getText().toString().equals("")){
                    Toast.makeText(Potenciacao.this, "Por favor, insira o valor da base", Toast.LENGTH_LONG).show();
                }else if(valor2.getText().toString().equals("")){
                    Toast.makeText(Potenciacao.this, "Por favor, insira o valor do expoente", Toast.LENGTH_LONG).show();
                }else{
                    potenciar();
                }

            }

        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public void potenciar() {

        base = Double.parseDouble(valor1.getText().toString());
        expoente = Double.parseDouble(valor2.getText().toString());

        if (base == null) {
            Toast.makeText(Potenciacao.this, "Por favor, insira o valor da base", Toast.LENGTH_LONG).show();
        }else {

            resultado = Math.pow(base, expoente);
            resultadov.setText(String.format("%.3f", resultado));

            List<String> lista = new ArrayList<String>();

            if (expoente < 0) {
                String conversao = decimalParaFracao(resultado);
                resultadov.setText(conversao);
            }

            for (double i = 1; i <= expoente; i++) {

                if (expoente != 1 && base != 1) {
                    lista.add(String.format("%.3f", base));
                } else if (expoente == 1) {
                    lista.add(String.format("%.3f", base));
                    lista.add("x 1");
                } else if (base == 1) {
                    lista.add(String.format("%.3f", base));
                }
                else if (expoente == 0) {
                    lista.add("1");
                }
                if (expoente != i) {
                    lista.add("x");
                }
            }

            passos.setText(String.valueOf(lista));
        }

    }

    public String decimalParaFracao(double number) {
        double intVal = Math.floor(number);

        double fVal = number - intVal;

        final long pVal = 1000000000;

        long gcdVal = (Math.round(fVal * pVal));

        long num = Math.round(fVal * pVal) / gcdVal;

        long deno = pVal / gcdVal;

        String result = (intVal * deno) + num + "/" + deno;

        return result;
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(),CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    }

}
