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

public class CalculadoraPerimetroRetanguloActivity extends AppCompatActivity {

    EditText editBase, editAltura;

    TextView passos, resultado;

    ImageView btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_perimetro_retangulo);

        passos = findViewById(R.id.textPassosPRetangulo);

        resultado = findViewById(R.id.textResultadoPRetangulo);

        editBase = findViewById(R.id.BaseRetPerimetro);

        editAltura = findViewById(R.id.AlturaRetPerimetro);

        btBack = findViewById(R.id.btBackPRetangulo);
    }


    @Override
    protected void onResume() {
        super.onResume();

        editAltura.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == keyEvent.KEYCODE_ENTER) {
                    if(!editAltura.getText().toString().trim().equals("") && !editBase.getText().toString().trim().equals("")){
                      calculaPerimetroRetangulo(Double.parseDouble(editBase.getText().toString().trim()),Double.parseDouble(editAltura.getText().toString().trim()));
                    }

                    else {
                        Toast.makeText(getApplicationContext(),"Informe uma base e altura valida!", Toast.LENGTH_LONG).show();
                    }

                }
                return false;
            }

        });

        editBase.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == keyEvent.KEYCODE_ENTER) {
                    if(!editAltura.getText().toString().trim().equals("") && !editBase.getText().toString().trim().equals("")){
                        calculaPerimetroRetangulo(Double.parseDouble(editBase.getText().toString().trim()),Double.parseDouble(editAltura.getText().toString().trim()));
                    }

                    else {
                        Toast.makeText(getApplicationContext(),"Informe uma base e altura valida!", Toast.LENGTH_LONG).show();
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

    private void calculaPerimetroRetangulo(double base, double altura){
        String text = "";

        text += "\n 2 . (b+h) \n\n";

        text += String.format("2 . (%.2f + %.2f)", base, altura);

        text += String.format("\n\n  2 . %.2f", base+altura);

        text += "\n\n";

        passos.setText(text);

        double result = 2 * (base+altura);

        resultado.setText(String.format("%.3f", result));

    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(),CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    }
}