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

public class TrapezioActivity extends AppCompatActivity implements FigurasPlanas{
    private Double baseMaior, baseMenor, altura, resultado, soma, multiplicacao, divisao;
    private EditText valor1, valor2, valor3;
    private TextView resultadov, formula, passo1, passo2, passo3;

    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapezio);

        valor1 = findViewById(R.id.editBaseMaior);
        valor2 = findViewById(R.id.editBaseMenor);
        valor3 = findViewById(R.id.editAltura);
        resultadov = findViewById(R.id.editResultado);
        formula = findViewById(R.id.txtViewFormula);
        passo1 = findViewById(R.id.txtViewPasso1);
        passo2 = findViewById(R.id.txtViewPasso2);
        passo3 = findViewById(R.id.txtViewPasso3);
        btnCalcular = findViewById(R.id.btnCalcular);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valor1.getText().toString().equals("")){
                    Toast.makeText(TrapezioActivity.this, "Por favor, insira o valor da base maior", Toast.LENGTH_LONG).show();
                }else if(valor2.getText().toString().equals("")){
                    Toast.makeText(TrapezioActivity.this, "Por favor, insira o valor da base menor", Toast.LENGTH_LONG).show();
                }else if(valor3.getText().toString().equals("")) {
                    Toast.makeText(TrapezioActivity.this, "Por favor, insira o valor da altura", Toast.LENGTH_LONG).show();
                }else{
                    calculaArea();
                }

            }

        });

    }

    @Override
    public void calculaArea() {
        baseMaior = Double.parseDouble(valor1.getText().toString());
        baseMenor = Double.parseDouble(valor2.getText().toString());
        altura = Double.parseDouble(valor3.getText().toString());
        resultado = ((baseMaior + baseMenor) * altura) / 2;
        resultadov.setText(String.valueOf(resultado));

        formula.setText("((" + baseMaior + " + " + baseMenor + ") * " + altura + ")" + "/ 2");

        soma = baseMaior + baseMenor;

        passo1.setText("(" + soma + " * " + altura + ")" + "/ 2");

        multiplicacao = soma * altura;

        passo2.setText(multiplicacao + "/ 2");

        divisao = multiplicacao / 2;

        passo3.setText(String.valueOf(divisao));
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(), CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    }
}
