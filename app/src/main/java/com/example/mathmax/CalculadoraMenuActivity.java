package com.example.mathmax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CalculadoraMenuActivity extends AppCompatActivity {

        private Spinner spinner;
        private int tipo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);


        spinner = (Spinner) findViewById(R.id.operacao);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.operacoes, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        spinner.setAdapter(adapter);

        Intent radiciacao = new Intent(getApplicationContext(),CalculadoraRadiciacaoActivity.class);
        Intent perimetroQuadrado = new Intent(getApplicationContext(),CalculadoraPerimetroQuadradoActvity.class);
        Intent perimetroRetangulo = new Intent(getApplicationContext(),CalculadoraPerimetroRetanguloActivity.class);
        Intent perimetroTriangulo = new Intent(getApplicationContext(),CalculadoraPerimetroTrianguloActivity.class);
        Intent perimetroLosangulo = new Intent(getApplicationContext(),CalculadorPerimetroLosanguloActivity.class);
        Intent perimetroTrapezio = new Intent(getApplicationContext(),CalculadoraPerimetroTrapezioActivity.class);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipo = position;
                    if(tipo == 1){
                        startActivity(radiciacao);
                    }

                    if(tipo ==2){
                        startActivity(perimetroQuadrado);
                    }

                    if(tipo ==3){
                        startActivity(perimetroRetangulo);
                    }

                    if(tipo == 4){
                        startActivity(perimetroTriangulo);
                    }

                    if(tipo == 5){
                        startActivity(perimetroLosangulo);
                    }

                    if(tipo == 6){
                        startActivity(perimetroTrapezio);
                    }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tipo = 0;
            }
        });
    }


    @Override
    public void onBackPressed(){
        Intent back = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(back);
        finish();
    }



}