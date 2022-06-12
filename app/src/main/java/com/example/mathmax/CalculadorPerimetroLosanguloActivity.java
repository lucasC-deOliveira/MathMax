package com.example.mathmax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculadorPerimetroLosanguloActivity extends AppCompatActivity {


    EditText lado;

    TextView passos, resultado;

    ImageView btBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculador_perimetro_losangulo);



        lado = findViewById(R.id.ladoLosanguloP);

        passos = findViewById(R.id.textPassosPLosangulo);

        resultado = findViewById(R.id.textResultadoPLosangulo);

        btBack = findViewById(R.id.btBackPLosangulo);
    }

    @Override
    protected void onResume() {
        super.onResume();

        lado.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == keyEvent.KEYCODE_ENTER) {
                    if(!lado.getText().toString().trim().equals("")){
                        calculaPerimetro(Double.parseDouble(lado.getText().toString().trim()));
                    }

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

    private void calculaPerimetro(double lado){
        String text = "\n\n";

        text += String.format("%.2f + %.2f + %.2f + %.2f", lado,lado,lado,lado);

        text += "\n \n OU \n\n";

        text += String.format("4  . %.2f  \n\n", lado);

        passos.setText(text);

        double result = 4 * lado;

        resultado.setText(String.format("%.3f",result));



    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(),CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    }
}