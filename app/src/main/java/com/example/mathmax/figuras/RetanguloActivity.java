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

public class RetanguloActivity extends AppCompatActivity implements FigurasPlanas{

    private double base, altura, resultado;
    private EditText valor1, valor2;
    private TextView resultadov, formula, passo1, passo2;

    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retangulo);

        valor1 = findViewById(R.id.editBase);
        valor2 = findViewById(R.id.editAltura);
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
                if(valor1.getText().toString().equals("")){
                    Toast.makeText(RetanguloActivity.this, "Por favor, insira o valor da base", Toast.LENGTH_LONG).show();
                }else if(valor2.getText().toString().equals("")){
                    Toast.makeText(RetanguloActivity.this, "Por favor, insira o valor da altura", Toast.LENGTH_LONG).show();
                }else{
                    calculaArea();
                }

            }

        });

    }

    @Override
    public void calculaArea() {
        base = Double.parseDouble(valor1.getText().toString());
        altura = Double.parseDouble(valor2.getText().toString());
        resultado = base * altura;
        resultadov.setText(String.valueOf(resultado));

        formula.setText(base + " x " + altura);

        passo1.setText(String.valueOf(resultado));

    }
    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(), CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    }
}
