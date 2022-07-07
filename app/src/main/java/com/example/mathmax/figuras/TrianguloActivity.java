package com.example.mathmax.figuras;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mathmax.CalculadoraMenuActivity;
import com.example.mathmax.Potenciacao;
import com.example.mathmax.R;

public class TrianguloActivity extends AppCompatActivity implements FigurasPlanas{

    private double base, altura, resultado, multiplicacao, divisao;;
    private EditText valor1, valor2;
    private TextView resultadov, formula,  passo1, passo2;;

    private Button btnCalcular;

    private ImageView btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);

        valor1 = findViewById(R.id.editBase);
        valor2 = findViewById(R.id.editAltura);
        resultadov = findViewById(R.id.editResultado);
        formula = findViewById(R.id.txtViewFormula);
        passo1 = findViewById(R.id.txtViewPasso1);
        passo2 = findViewById(R.id.txtViewPasso2);
        btnCalcular = findViewById(R.id.btnCalcular);
        btBack = findViewById(R.id.btBackTriangulo);

    }

    @Override
    protected void onResume() {
        super.onResume();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valor1.getText().toString().equals("")){
                    Toast.makeText(TrianguloActivity.this, "Por favor, insira o valor da base", Toast.LENGTH_LONG).show();
                }else if(valor2.getText().toString().equals("")){
                    Toast.makeText(TrianguloActivity.this, "Por favor, insira o valor da altura", Toast.LENGTH_LONG).show();
                }else{
                    calculaArea();
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

    @Override
    public void calculaArea() {
        base = Double.parseDouble(valor1.getText().toString());
        altura = Double.parseDouble(valor2.getText().toString());
        resultado = (base * altura) / 2;
        resultadov.setText((String.format("%.3f", resultado)));

        formula.setText("(" + (String.format("%.3f", base)) + " x " + (String.format("%.3f", altura)) + ")" + "/2");

        multiplicacao = base * altura;

        passo1.setText((String.format("%.3f", multiplicacao)) + "/2");

        divisao = multiplicacao / 2;

        passo2.setText(String.format("%.3f", divisao));
    }


    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(), CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    }
}
