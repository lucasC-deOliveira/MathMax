package com.example.mathmax.figuras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mathmax.CalculadoraMenuActivity;
import com.example.mathmax.R;

public class QuadradoActivity extends AppCompatActivity implements FigurasPlanas{

    private double lado, resultado;
    private EditText valor;
    private TextView resultadov, formula, passo1;

    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadrado);

        valor = findViewById(R.id.editLado);
        resultadov = findViewById(R.id.editResultado);
        formula = findViewById(R.id.txtViewFormula);
        passo1 = findViewById(R.id.txtViewPasso1);
        btnCalcular = findViewById(R.id.btnCalcular);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valor.getText().toString().equals("")){
                    Toast.makeText(QuadradoActivity.this, "Por favor, insira o valor de um dos lados", Toast.LENGTH_LONG).show();
                } else{
                    calculaArea();
                }

            }

        });

    }

    @Override
    public void calculaArea() {
        lado = Double.parseDouble(valor.getText().toString());
        resultado = Math.pow(lado, 2);
        resultadov.setText(String.valueOf(resultado));

        formula.setText(lado + " x " + lado);

        passo1.setText(String.valueOf(resultado));
    }


    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(),CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    }



}
