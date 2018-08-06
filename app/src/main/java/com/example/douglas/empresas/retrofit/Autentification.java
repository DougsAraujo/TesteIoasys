package com.example.douglas.empresas.retrofit;

import android.util.Log;

import com.example.douglas.empresas.LoginActivity;
import com.example.douglas.empresas.R;
import com.example.douglas.empresas.User;
import com.example.douglas.empresas.UserRequest;
import com.example.douglas.empresas.services.EmpresaServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Douglas on 03/08/2017.
 */

public class Autentification {

    private User usuario;
    private Retrofit retrofit;
    private final EmpresaServices empresasServices;
    final LoginActivity login;

    /**Construtor da classe para realizar a autenticação do usuário.
    * Criando a instância do retrofit.
    * empresaServices objeto da interface empresas.
     */
    public  Autentification(LoginActivity login) {
        this.login = login;

        RetrofitInitiator conection = new RetrofitInitiator();
        retrofit = conection.getInitiator();
        empresasServices = retrofit.create(EmpresaServices.class);

    }

    /** O método Logar realiza a chamada da validação na Interface com o objeto empresasServices.
      * Recebendo a resposta, caso haja sucesso os Headers são guardados no UseRequest
      * O useRequest e o pojo criado para receber as informações.
      * Caso ocorra falha, o método msgerror na activity Login informa o ocorrido.
     */

    public void Logar(String email, String senha){


        usuario = new User(email,senha);

        Call call = empresasServices.validacao(usuario);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            if(response.isSuccessful()){

                UserRequest useRequest = new UserRequest(response.headers().get("access-token"),
                response.headers().get("client"),
                        response.headers().get("uid"));

                Log.d("access-token",response.headers().get("access-token"));
                Log.d("client",response.headers().get("client"));
                Log.d("uid",response.headers().get("uid"));
                login.Chamada(useRequest);

            }else {

                login.msgerror(login.getString(R.string.userpass));
             }

            }

            @Override
            public void onFailure(Call call, Throwable t) {


                login.msgerror(t.getMessage());


            }
        });



    }

}
