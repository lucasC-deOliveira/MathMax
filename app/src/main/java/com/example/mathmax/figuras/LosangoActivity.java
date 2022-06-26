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

public class LosangoActivity extends AppCompatActivity implements FigurasPlanas{
    private Double diagonalMaior, diagonalMenor, resultado, multiplicacao, divisao;
    private EditText valor1, valor2;
    private TextView resultadov, formula, passo1, passo2;

    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losango);

        valor1 = findViewById(R.id.editDiagonalMaior);
        valor2 = findViewById(R.id.editDiagonalMenor);
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
                    Toast.makeText(LosangoActivity.this, "Por favor, insira o valor da diagonal maior", Toast.LENGTH_LONG).show();
                }else if(valor2.getText().toString().equals("")){
                    Toast.makeText(LosangoActivity.this, "Por favor, insira o valor da diagonal menor", Toast.LENGTH_LONG).show();
                }else{
                    calculaArea();
                }

            }

        });

    }

    @Override
    public void calculaArea() {
        diagonalMaior = Double.parseDouble(valor1.getText().toString());
        diagonalMenor = Double.parseDouble(valor2.getText().toString());
        resultado = (diagonalMaior * diagonalMenor) / 2;
        resultadov.setText(String.valueOf(resultado));

        formula.setText("(" + diagonalMaior + " x " + diagonalMenor + ")" + "/ 2");

        multiplicacao = diagonalMaior * diagonalMenor;

        passo1.setText(multiplicacao + "/ 2");

        divisao = multiplicacao / 2;

        passo2.setText(String.valueOf(divisao));
    }


    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(),CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    }
}
