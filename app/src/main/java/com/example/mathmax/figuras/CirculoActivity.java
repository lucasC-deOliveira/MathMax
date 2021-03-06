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

public class CirculoActivity extends AppCompatActivity implements FigurasPlanas{

    private Double raio, raio1, resultado;
    private EditText valor1;
    private TextView resultadov, formula, passo1, passo2;

    private static final double pi = 3.14;

    private Button btnCalcular, btnCalcularComprimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo_area);

        valor1 = findViewById(R.id.editRaio);
        resultadov = findViewById(R.id.editResultado);
        formula = findViewById(R.id.txtViewFormula);
        passo1 = findViewById(R.id.txtViewPasso1);
        passo2 = findViewById(R.id.txtViewPasso2);
        btnCalcular = findViewById(R.id.btnCalcular);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valor1.getText().toString().equals("")){
                    Toast.makeText(CirculoActivity.this, "Por favor, insira o valor do raio", Toast.LENGTH_LONG).show();
                } else{
                    calculaArea();
                }

            }

        });

    }

    public void calculaArea() {

        raio = Double.parseDouble(valor1.getText().toString());

        formula.setText("(" + raio + " x " + raio + ")" + " * " + pi);

        raio1 = Math.pow(raio, 2);

        passo1.setText(raio1 + " * " + pi);

        resultado = raio1 * pi;

        passo2.setText(String.valueOf(resultado));

        resultadov.setText(String.valueOf(resultado));


    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(), CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    }
}
