package com.example.mathmax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraPerimetroTrapezioActivity extends AppCompatActivity {

    EditText baseMaior, baseMenor, lado1, lado2;

    ImageView btBack;

    TextView resultado, passos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_perimetro_trapezio);

        loadComponents();
    }


    @Override
    protected void onResume() {
        super.onResume();


        baseMaior.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(!baseMaior.getText().toString().trim().equals("") && !baseMenor.getText().toString().trim().equals("") && !lado1.getText().toString().trim().equals("") && !lado2.getText().toString().trim().equals("")){
                    calculaPerimetro(
                            Double.parseDouble(baseMaior.getText().toString().trim()),
                            Double.parseDouble(baseMenor.getText().toString().trim()),
                            Double.parseDouble(lado1.getText().toString().trim()),
                            Double.parseDouble(lado2.getText().toString().trim())

                    );
                }

                return false;
            }
        });

        baseMenor.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(!baseMaior.getText().toString().trim().equals("") && !baseMenor.getText().toString().trim().equals("") && !lado1.getText().toString().trim().equals("") && !lado2.getText().toString().trim().equals("")){
                    calculaPerimetro(
                            Double.parseDouble(baseMaior.getText().toString().trim()),
                            Double.parseDouble(baseMenor.getText().toString().trim()),
                            Double.parseDouble(lado1.getText().toString().trim()),
                            Double.parseDouble(lado2.getText().toString().trim())

                    );
                }

                return false;
            }
        });

        lado1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(!baseMaior.getText().toString().trim().equals("") && !baseMenor.getText().toString().trim().equals("") && !lado1.getText().toString().trim().equals("") && !lado2.getText().toString().trim().equals("")){
                    calculaPerimetro(
                            Double.parseDouble(baseMaior.getText().toString().trim()),
                            Double.parseDouble(baseMenor.getText().toString().trim()),
                            Double.parseDouble(lado1.getText().toString().trim()),
                            Double.parseDouble(lado2.getText().toString().trim())

                    );
                }

                return false;
            }

        });


        lado2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(!baseMaior.getText().toString().trim().equals("") && !baseMenor.getText().toString().trim().equals("") && !lado1.getText().toString().trim().equals("") && !lado2.getText().toString().trim().equals("")){
                    calculaPerimetro(
                            Double.parseDouble(baseMaior.getText().toString().trim()),
                            Double.parseDouble(baseMenor.getText().toString().trim()),
                            Double.parseDouble(lado1.getText().toString().trim()),
                            Double.parseDouble(lado2.getText().toString().trim())

                    );
                }
                else {
                    Toast.makeText(getApplicationContext(),"Informe todos os parâmetros!", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });


        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void calculaPerimetro(double bMaior, double bMenor, double l1, double l2){
        String text = "\n  B + b + L1 + L2.";

        text += String.format("\n\n %.2f + %.2f + %.2f + %.2f", bMaior,bMenor,l1,l2);

        text += "\n\n";

        passos.setText(text);

        double result = bMaior + bMenor + l1 + l2 ;

        resultado.setText(String.format("%.3f",result));
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(),CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    }


    private void loadComponents(){
        baseMaior = findViewById(R.id.baseMaiorTraP);

        baseMenor = findViewById(R.id.baseMenorTraP);

        lado1 = findViewById(R.id.lado1TrapP);

        lado2 = findViewById(R.id.lado2Trap);

        btBack = findViewById(R.id.btBackPTrapezio);

        passos = findViewById(R.id.textPassosPTrapezio);

        resultado = findViewById(R.id.textResultadoPTrapezio);
    }
}