package com.example.mathmax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastrarActivity extends AppCompatActivity {
    private Button btAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        btAction = findViewById(R.id.cadastarButtonCadastro);


        if(MainActivity.isAutheticated){
            goToApp();
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        btAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.isAutheticated=true;
                goToApp();
            }
        });
    }

    private void goToApp(){
        Intent main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(main);
        finish();
    }
}