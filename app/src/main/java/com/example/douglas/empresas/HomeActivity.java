package com.example.douglas.empresas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

import com.example.douglas.empresas.retrofit.FindEnterprises;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    private ListView lista;
    private TextView texto_inicial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /* O widget abar utilizar o degrades armazenado no drawable para mudar as cores na ActionBar
            viewActionBar infla o layout actionbar na ActionBar da HomeActivity
            Mudando o parametros da actionbar é possivel realizar a centralização do logo da ioasys
         */
        final ActionBar abar = getSupportActionBar();
        abar.setBackgroundDrawable(getResources().getDrawable(R.drawable.degrades));
        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);

        lista = (ListView) findViewById(R.id.lista);
        texto_inicial = (TextView) findViewById(R.id.introducao);


        }

        /*
            Foi utilizado um searchview para realizar a busca das empresas, como um item do menu
            Quando o usuário submeter o texto pesquisado, e invocado o objeto findEnterprises, que realiza a busca
            no WebService utilizando como parametro o texto;
         */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);

        UserRequest userRequest =  (UserRequest) getIntent().getSerializableExtra("user");
        final FindEnterprises findEnterprises = new FindEnterprises(userRequest,HomeActivity.this);
        final MenuItem itemmenu = menu.findItem(R.id.busca);
        final SearchView searchView = (SearchView) itemmenu.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String resultado) {
                if (!searchView.isIconified()) {
                    findEnterprises.BuscarEmpresas(resultado,HomeActivity.this);
                }
                itemmenu.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                return false;
            }
        });


        return true;
    }

    public void msgerror(String erro) {
        Toast.makeText(getBaseContext(), erro, Toast.LENGTH_LONG).show();

    }

    /*
        O método Buscar recebe a lista das empresas encontradas e as insere no Adapter customizado;
        Quando for realizado o clique em algum item da lista, é criado um Intent e um Bundle;
        O bundle irá armazear o nome e a descrição da empresa selecionada, utilizando como um  objeto de chave/valor;
        Já o Intent fará a ligação entre as Activitys, e pegará o bundle com as informações necessárias, e as
        enviará para próxima acitivity;
     */

    public void Buscar(final ListaEmpresas empresaList){



        final ArrayList<Empresa> empresas = empresaList.getEmpresaLista();
        if(empresas.size()==0){
                Toast.makeText(this, "Nenhum resultado obtido!", Toast.LENGTH_SHORT).show();

        }
        else {

            texto_inicial.setVisibility(View.INVISIBLE);

            final AdapterEmpresa enterpriseAdapter = new AdapterEmpresa(empresas, getBaseContext());
            lista.setAdapter(enterpriseAdapter);

            lista.setVisibility(View.VISIBLE);

            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(HomeActivity.this, DescricaoEmpresa.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("nome",empresas.get(position).getEnterpriseName());
                    bundle.putString("descricao",empresas.get(position).getDescription());

                    i.putExtras(bundle);
                    startActivity(i);
                }
            });

        }



    }


}


