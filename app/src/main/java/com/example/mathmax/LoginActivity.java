package com.example.mathmax;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button actButton;
    private EditText editEmail, editPass;
    private ImageView btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        actButton = findViewById(R.id.logginButtonLogin);

        editEmail = findViewById(R.id.EditEmailLogin);
        editPass = findViewById(R.id.editPassLogin);

        btBack = findViewById(R.id.btBackLogin);

    }



    @Override
    protected void onResume() {
        super.onResume();

        actButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString().trim();
                String senha = editPass.getText().toString().trim();
                if (!senha.equals("") && !email.equals("")){
                MainActivity.usuario.signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Seu login foi realizado com sucesso.",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else{
                            Toast.makeText(getApplicationContext(),"Seu login não foi realizado, por favor, verifique suas credenciais.",Toast.LENGTH_LONG).show();
                        }
                    }
                });
                }
                else {
                    Toast.makeText(getApplicationContext(),"Por favor, preencha os campos.",Toast.LENGTH_LONG).show();
                }
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void goToApp(){
        Intent main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(main);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(getApplicationContext(), LoginMenuActivity.class);
        startActivity(back);
        finish();
    }
}