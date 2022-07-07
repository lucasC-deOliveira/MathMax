package com.example.mathmax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mathmax.figuras.CirculoActivity;
import com.example.mathmax.figuras.CirculoComprimentoActivity;
import com.example.mathmax.figuras.LosangoActivity;
import com.example.mathmax.figuras.QuadradoActivity;
import com.example.mathmax.figuras.RetanguloActivity;
import com.example.mathmax.figuras.TrapezioActivity;
import com.example.mathmax.figuras.TrianguloActivity;

public class CalculadoraMenuActivity extends AppCompatActivity {

        private Spinner spinner;
        private int tipo;
        private ImageView btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        btBack = findViewById(R.id.btBackCalc);

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

        Intent circulo = new Intent(getApplicationContext(), CirculoActivity.class);
        Intent circuloComprimento = new Intent(getApplicationContext(), CirculoComprimentoActivity.class);
        Intent quadrado = new Intent(getApplicationContext(), QuadradoActivity.class);
        Intent retangulo = new Intent(getApplicationContext(), RetanguloActivity.class);
        Intent triangulo = new Intent(getApplicationContext(), TrianguloActivity.class);
        Intent losango = new Intent(getApplicationContext(), LosangoActivity.class);
        Intent trapezio = new Intent(getApplicationContext(), TrapezioActivity.class);

        Intent potenciacao = new Intent(getApplicationContext(), Potenciacao.class);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipo = position;

                switch (tipo){
                    case 1:
                        startActivity(radiciacao);
                        break;

                    case 2:
                        startActivity(perimetroQuadrado);
                        break;

                    case 3:
                        startActivity(perimetroRetangulo);
                        break;

                    case 4:
                        startActivity(perimetroTriangulo);
                        break;

                    case 5 :
                        startActivity(perimetroLosangulo);
                        break;

                    case 6:
                        startActivity(perimetroTrapezio);
                        break;

                    case 7:
                        startActivity(quadrado);
                        break;

                    case 8:
                        startActivity(retangulo);
                        break;

                    case 9:
                        startActivity(triangulo);
                        break;
                    case 10:
                        startActivity(losango);
                        break;

                    case 11:
                        startActivity(trapezio);
                        break;

                    case 12:
                        startActivity(circulo);
                        break;

                    case 13:
                        startActivity(circuloComprimento);
                        break;

                    case 14:
                        startActivity(potenciacao);
                        break;


                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tipo = 0;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
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