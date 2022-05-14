package com.example.mathmax;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DadosActivity extends AppCompatActivity {

    private Button actButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        actButton = findViewById(R.id.button);


        if(MainActivity.isAutheticated){
            goToApp();
            finish();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        actButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.isAutheticated = true;
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
