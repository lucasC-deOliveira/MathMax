package com.example.mathmax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static boolean isAutheticated = false;

    private Button btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!isAutheticated){
            Intent login = new Intent(this, LoginMenuActivity.class);
            startActivity(login);
            finish();
        }
    btSair = findViewById(R.id.btSair);

    }

    @Override
    protected void onResume() {
        super.onResume();
        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAutheticated = false;
                Intent menuLogin = new Intent(getApplicationContext(), LoginMenuActivity.class);
                startActivity(menuLogin);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}