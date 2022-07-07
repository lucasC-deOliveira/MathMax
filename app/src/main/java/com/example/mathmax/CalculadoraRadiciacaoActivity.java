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

import java.util.ArrayList;
import java.util.List;

public class CalculadoraRadiciacaoActivity extends AppCompatActivity {

    private EditText raiz, radicando;

    private TextView passos, resultado;

    private int numberRaiz = 0, numberRadicando = 0;

    private ImageView btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_radiciacao);

        raiz = findViewById(R.id.raiz);

        radicando = findViewById(R.id.radiacando);

        passos = findViewById(R.id.textPassos);

        passos.setText("\n\n\n\n\n\n");

        resultado = findViewById(R.id.textResultado);

        btBack = findViewById(R.id.btBackRadiciacao);


    }


    @Override
    protected void onResume() {
        super.onResume();

            raiz.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == keyEvent.KEYCODE_ENTER) {
                   String raizText = raiz.getText().toString();
                   if(!raizText.equals("")){
                       numberRaiz = Integer.parseInt(raizText);
                       return true;
                   }
                }

                return false;

            }
        });

            radicando.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == keyEvent.KEYCODE_ENTER) {
                        String radicandoText = radicando.getText().toString();
                        String raizText = raiz.getText().toString();
                        if(!raizText.equals("")){
                            numberRaiz = Integer.parseInt(raizText);}
                        if(!radicandoText.equals("")){
                            numberRadicando= Integer.parseInt(radicandoText);
                            if(numberRaiz != 0 && numberRadicando != 0){
                                raizCalc(numberRaiz,numberRadicando);
                                return true;
                            }
                            else if(numberRaiz == 0 && numberRadicando == 0){
                                Toast.makeText(getApplicationContext(),"a raiz e a base base da raiz deve ser diferente de zero!!!!", Toast.LENGTH_LONG).show();
                            }
                             else if(numberRaiz == 0 && numberRadicando != 0){
                                Toast.makeText(getApplicationContext(),"a raiz deve ser diferente de zero!!!!", Toast.LENGTH_LONG).show();
                           }
                           else if(numberRadicando == 0 && numberRaiz != 0 ){
                                Toast.makeText(getApplicationContext(),"a base da raiz deve ser diferente de zero!!!!", Toast.LENGTH_LONG).show();
                            }



                            return true;
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

    @Override
    public void onBackPressed(){
        Intent back = new Intent(getApplicationContext(), CalculadoraMenuActivity.class);
        startActivity(back);
        finish();
    };

    private void raizCalc(int raiz, int radicando){

        int radicandoAux= radicando;

        int count = 2;

        List<Integer> mmc= new ArrayList();

        boolean ok = false;
        while(!ok){
            if(radicandoAux % count == 0){
                radicandoAux = radicandoAux / count;
                mmc.add(count);
            }
            else{
                count++;
            }
            if(radicandoAux == 1){
                ok = true;
            }
        }

        List<Potencia>  potencias = new ArrayList<>();

        List <Integer> searched = new ArrayList<>();

        for(int i : mmc){
            int repetition = 0;
            boolean isSearched =  searched.contains(i);
            if(isSearched) {
                continue;
            }
            for(int e : mmc){
                if(i == e){
                    repetition++;
                }
            }
            if(repetition  % raiz == 0){
                int nP = repetition / raiz;
                while(nP != 0){
                    Potencia p = new Potencia(raiz,i);
                    potencias.add(p);
                    nP--;
                }
                searched.add(i);

            }
            else if(repetition  % raiz != 0){
                Potencia p = new Potencia(repetition,i);
                potencias.add(p);
                searched.add(i);
            }
        }


        String text = "";
        int indice = 1 ;
        for(Potencia p : potencias){
            int num = (int) p.getNumero();
            int potencia =  (int) p.getPotencia();
            text += raiz+"^√"+num + "^" + potencia ;
                    if(indice < potencias.size()){
                       text+= " . ";
                    }
                    indice++;
        }



        indice = 1 ;
            text+=" \n \n";

            String passo2 ="";
            boolean hasUnsimpleRoot = false;
        for(Potencia p : potencias){
            if(p.getPotencia() == raiz){
                int num = (int) p.getNumero();
                passo2 += num+"";
            }
            else if(p.getPotencia() != raiz){
                if(p.getPotencia() == 1){
                    int num = (int) p.getNumero();
                    passo2+= raiz+"^√"+num;
                    hasUnsimpleRoot = true;
                }
                else{
                    int num = (int) p.getNumero();
                    int potencia =  (int) p.getPotencia();
                    passo2+= raiz+"^√"+num+" ^ "+potencia;
                    hasUnsimpleRoot = true;
                }

            }

            if(indice < potencias.size()){
                passo2+= " . ";
            }
            indice++;
        }


        text+=passo2;
        if(hasUnsimpleRoot) {
            indice = 1;
            String passo3 = "\n\n";
            String passo4 = "\n\n";
            String passo5 = "\n\n";
            for (Potencia p : potencias) {
                int num = (int) p.getNumero();
                int potencia =  (int) p.getPotencia();
                if (p.getPotencia() == raiz) {
                    passo3 += num + "";
                    passo4 += num + "";
                    passo5 += num + "";
                } else if (p.getPotencia() != raiz) {
                    passo3 += num + "^" + potencia + "/" + raiz;
                    double newPotencia = p.getPotencia() / raiz;
                    passo4 += num + "^" + String.format("%.2f",newPotencia);
                    passo5 += String.format("%.2f",Math.pow(num,newPotencia));
                }

                if (indice < potencias.size()) {
                    passo3 += " . ";
                    passo4 += " . ";
                    passo5 += " . ";
                }
                indice++;
            }


            text += passo3;
            text += passo4;
            text += passo5;
        }
        else {
            text = "\n\n"+text+"\n\n";
        }

        double result = 0;

        for(Potencia p : potencias){
            if(p.getPotencia() == raiz){
                if(result == 0){
                    result = p.getNumero();
                }
                else {
                    result *= p.getNumero();
                }
            }
            else if(p.getPotencia() != raiz){
                double newPotencia = p.getPotencia() / raiz ;
                if(result == 0){
                    result= Math.pow(p.getNumero(), newPotencia);
                }
                else {
                    result*= Math.pow(p.getNumero(), newPotencia);
                }


            }

        }


        passos.setText(text);
        resultado.setText(String.format("%.3f",result));


    }

    private double radiciacao(int raiz,int radicando){

        double resultado = Double.parseDouble(""+radicando);
        while(raiz != 0){
            resultado = resultado/radicando;
            raiz--;
        }
        return  resultado;
    }


    private class Potencia{
      private double potencia;
      private double numero;

        public Potencia(double potencia, double numero){
            this.potencia = potencia;
            this.numero = numero;
        }

        public double getPotencia(){
            return this.potencia;
        }

        public void setPotencia(double potencia){
            this.potencia = potencia;
        }

        public double getNumero(){
            return this.numero;
        }

        public void setNumero(double numero){
            this.numero = numero;
        }

        @Override
        public String toString() {
            return "Potencia{" +
                    "potencia=" + potencia +
                    ", numero=" + numero +
                    '}';
        }
    }


}



