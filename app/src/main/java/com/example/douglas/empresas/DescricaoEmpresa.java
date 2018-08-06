package com.example.douglas.empresas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DescricaoEmpresa extends AppCompatActivity {

    private TextView descricao;
    private String desc_empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_empresa);

       /** A descricao e inserida no TextView descricao_empresa no Layout da Activity DescricaoEmpresa.
        * Essa descricao foi conseguida através do Intent
        */
        descricao = (TextView) findViewById(R.id.descricao_empresa);
        desc_empresa = getIntent().getStringExtra("descricao").toString();
        descricao.setText(desc_empresa);

         /** O componente act insere no título o nome da empresa que foi passado através do Intent
         */

        final ActionBar abar = getSupportActionBar();
        abar.setBackgroundDrawable(getResources().getDrawable(R.drawable.degrades));
        abar.setTitle(getIntent().getStringExtra("nome").toString());
        abar.setDisplayHomeAsUpEnabled(true);


        }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {

                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                finish();
        return true;

    }

}
