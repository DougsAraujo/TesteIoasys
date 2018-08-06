package com.example.douglas.empresas.retrofit;

import android.util.Log;

import com.example.douglas.empresas.HomeActivity;
import com.example.douglas.empresas.ListaEmpresas;
import com.example.douglas.empresas.UserRequest;
import com.example.douglas.empresas.services.EmpresaServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Douglas on 04/08/2017.
 */

public class FindEnterprises {

    private Retrofit retrofit;
    private EmpresaServices empresaServices;
    private UserRequest userRequest;
    private HomeActivity homeActivity;

    /**
        FindEnterprises cria a conexão com o retrofit e faz a comunicação com a interface
        dos métodos do WebService
     */

    public FindEnterprises(UserRequest userRequest,HomeActivity homeActivity){
        RetrofitInitiator conection = new RetrofitInitiator();
        retrofit = conection.getInitiator();
        this.empresaServices = retrofit.create(EmpresaServices.class);
        this.userRequest = userRequest;
        this.homeActivity = homeActivity;
    }

    /**
        O método BuscarEmpresas recebe o texto digitado no SearchView e a view HomeActivity
        empresaServices realiza a chamada do ListEmpresa que recebe o token, client e o uid para ser fazer a conexao da chamada
        do método.
        Caso haja resposta, e emitido o resultado para o método buscar na HomeActivity
        Se não, e enviado para o método msgerror que informa que não há nenhum resultado com aquele texto;
     */
   public void BuscarEmpresas(String texto, final HomeActivity homeActivity){


       if(userRequest != null){
            Call call =  empresaServices.ListEmpresas(userRequest.getAcessToken(),userRequest.getClient(),
                    userRequest.getUid(), texto);

            call.enqueue(new Callback<ListaEmpresas>() {
                @Override
                public void onResponse(Call<ListaEmpresas> call, Response<ListaEmpresas> response) {

                    Log.d("Body ", response.body().toString());
                   homeActivity.Buscar(response.body());
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    homeActivity.msgerror(t.getMessage());
                }
            });
        }
    }
}
