package com.example.mathmax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    static FirebaseAuth usuario= FirebaseAuth.getInstance();

    private Button btSair, btCalc, btSobre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(usuario.getCurrentUser() == null){
            Intent login = new Intent(this, LoginMenuActivity.class);
            startActivity(login);
            finish();
        }
         btSair = findViewById(R.id.btSair);
        btCalc = findViewById(R.id.btCalcMain);
        btSobre = findViewById(R.id.sobrebutton);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario.signOut();
                Intent menuLogin = new Intent(getApplicationContext(), LoginMenuActivity.class);
                startActivity(menuLogin);
                finish();
            }
        });

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calc = new Intent(getApplicationContext(),CalculadoraMenuActivity.class);
                startActivity(calc);
            }
        });

        btSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sobre = new Intent(getApplicationContext(),SobreActivity.class);
                startActivity(sobre);
            }
        });
    }



    @Override
    public void onBackPressed() {
    }
}