package com.example.douglas.empresas.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Douglas on 02/08/2017.
 */

public class RetrofitInitiator {

    /** Classe que faz a conexão com o WebService da ioasys.
    */
    private static final String Endereco = "http://54.94.179.135:8090";
    private static final String Versao = "v1";

           public Retrofit getInitiator() {


               Retrofit retrofit = new Retrofit.Builder().baseUrl(Endereco + "/api/" + Versao + "/")
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();

               return retrofit;
           }

}
