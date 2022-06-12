package com.example.mathmax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class LoginMenuActivity extends AppCompatActivity {

    private Button login, cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_menu);

        login = findViewById(R.id.logginbutton);

        cadastrar = findViewById(R.id.cadastrarButton);

    }

    @Override
    protected void onStart() {
        super.onStart();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login);
            }
        });


        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent cadastrar = new Intent(getApplicationContext(), CadastrarActivity.class);
               startActivity(cadastrar);
            }
        });
    }
}