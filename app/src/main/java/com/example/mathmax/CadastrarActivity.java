package com.example.mathmax;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastrarActivity extends AppCompatActivity {
    private Button btAction;
    private ImageView btBackCadastro;
    private EditText editEmail, editPass, editConfirmPass, editNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        btAction = findViewById(R.id.cadastarButtonCadastro);

        editEmail = findViewById(R.id.editEmailCadastro);

        editPass = findViewById(R.id.editSenhaCadastro);

        editConfirmPass = findViewById(R.id.editSenhaConfirmCadastro);

        editNome = findViewById(R.id.EditNomeCadastro);

        btBackCadastro = findViewById(R.id.btBackCadastro);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString().trim();
                String senha = editPass.getText().toString().trim();
                String senhaConfirmacao = editConfirmPass.getText().toString().trim();
                String nome = editNome.getText().toString().trim();
                if(!email.equals("") && senha.equals(senhaConfirmacao) && !nome.equals("") && !senha.equals("") && !senhaConfirmacao.equals("")){
                    MainActivity.usuario.createUserWithEmailAndPassword(email, senha).addOnCompleteListener((Activity) CadastrarActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                goToApp();
                            }
                            else if(!task.isSuccessful()) {
                                try {
                                    throw task.getException();
                                } catch(FirebaseAuthWeakPasswordException e) {
                                    Toast.makeText(getApplicationContext(),"Senha fraca!",Toast.LENGTH_LONG).show();
                                } catch(FirebaseAuthInvalidCredentialsException e) {
                                    Toast.makeText(getApplicationContext(),"Email ou senha invalidos!",Toast.LENGTH_LONG).show();
                                } catch(FirebaseAuthUserCollisionException e) {
                                    Toast.makeText(getApplicationContext(),"Usuario com este email ja existe!",Toast.LENGTH_LONG).show();
                                } catch(Exception e) {
                                    Log.e("ErroCadastro", e.getMessage());
                                }
                            }
                        }
                    });
                }

                else if(email.equals("")  && !nome.equals("") ){
                    Toast.makeText(getApplicationContext(),"Preencha o email",Toast.LENGTH_LONG).show();
                }

                else if(!senha.equals(senhaConfirmacao) && !email.equals("")  &&  !nome.equals("")  && !senha.equals("") && !senhaConfirmacao.equals("")){
                    Toast.makeText(getApplicationContext(),"As senhas devem ser identicas",Toast.LENGTH_LONG).show();
                }

                else if(nome.equals("")){
                    Toast.makeText(getApplicationContext(),"Informe o seu nome",Toast.LENGTH_LONG).show();
                }
                else if(senha.equals("") && !email.equals("") && !nome.equals("") ){
                    Toast.makeText(getApplicationContext(),"Preencha a senha",Toast.LENGTH_LONG).show();
                }

                else if(senhaConfirmacao.equals("") && !email.equals("")  && !nome.equals("") && !senha.equals("")){
                    Toast.makeText(getApplicationContext(),"Preencha a confirmação de senha",Toast.LENGTH_LONG).show();
                }




            }
        });

        btBackCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(getApplicationContext(), LoginMenuActivity.class);
                startActivity(back);
                finish();
            }
        });
    }

    private void goToApp(){
        Intent main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(main);
        finish();
    }
}