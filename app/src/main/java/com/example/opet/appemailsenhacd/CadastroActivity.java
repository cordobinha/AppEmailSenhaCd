package com.example.opet.appemailsenhacd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastroActivity extends AppCompatActivity {


    private EditText editLogin, editSenha, editSenha2;
    private TextView textmensagem;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editLogin=findViewById(R.id.editLogin);
        editSenha=findViewById(R.id.editSenha);
        editSenha2=findViewById(R.id.editSenha2);
        textmensagem=findViewById(R.id.textViewMensagem);

        mAuth=FirebaseAuth.getInstance();

    }

    public void signUpFB(View view){
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();
        String senha2 = editSenha2.getText().toString();

        if(!senha.equals(senha2)){
            textmensagem.setVisibility(View.VISIBLE);
            textmensagem.setText("Senhas não conferem.");
        }
        else{
            textmensagem.setVisibility(View.VISIBLE);
            textmensagem.setText("Criando usuário...");
            mAuth.createUserWithEmailAndPassword(login,senha).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    textmensagem.setText("Usuário criado com sucesso! Redirecionando...");
                    dashRedirect();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    textmensagem.setText("Não foi possível criar o usuário.");
                }
            });
        }
    }
    void dashRedirect(){
        Intent novaTela = new Intent(CadastroActivity.this,TelaFilmesActivity.class);
        startActivity(novaTela);
    }


}
