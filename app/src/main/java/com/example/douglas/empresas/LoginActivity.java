package com.example.douglas.empresas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.douglas.empresas.retrofit.Autentification;

public class LoginActivity extends AppCompatActivity {

    private Button bt_login;
    private TextView user;
    private TextView senha;
    private Autentification autentification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        /** abar instância o widget ActionBar, assim o background é mudado com o degrades gerado.
         */

        final ActionBar abar = getSupportActionBar();
        abar.setBackgroundDrawable(getResources().getDrawable(R.drawable.degrades));
        getSupportActionBar().hide();
        /** O botão login, ao receber o clique cria o objeto autenfication da classe Autentification
         * É passado para o método logar do objeto autenfication, o que é digitado pelo usuário,
         * como o login(e-mail) e a senha.
         */

         bt_login = (Button) findViewById(R.id.button_login);
        user = (TextView) findViewById(R.id.email);
        senha = (TextView) findViewById(R.id.senha);



        bt_login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                    autentification = new Autentification(LoginActivity.this);
                    autentification.Logar(user.getText().toString(),senha.getText().toString());


            }
        });

    /** msgerror, emite um Toast, informando a falha na conexão.
     */

    }

    public void msgerror(String erro) {
        Toast.makeText(getBaseContext(), erro, Toast.LENGTH_LONG).show();

    }

    /** O método Chamada passa através de um intent o userRequest com o acess-token, client e uid
     *    gerado pelo método Logar na classe Autenfication.
     *    E informa o sucesso de Login.
     */

    public  void Chamada(UserRequest useRequest) {

        Intent i = new Intent(LoginActivity.this,HomeActivity.class);
        i.putExtra("user", useRequest);
        Toast.makeText(this, "Login efetuado com Sucesso!", Toast.LENGTH_SHORT).show();

        startActivity(i);

    }
}
