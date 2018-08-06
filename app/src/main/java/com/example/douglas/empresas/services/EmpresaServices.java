package com.example.douglas.empresas.services;

import com.example.douglas.empresas.ListaEmpresas;
import com.example.douglas.empresas.User;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Douglas on 02/08/2017.
 */

public interface EmpresaServices {

    @POST("users/auth/sign_in")
    Call<User> validacao(@Body User user);

    @GET("enterprises")
    Call<ListaEmpresas> ListEmpresas(
            @Header("access-token") String acess_token,
            @Header("client") String client,
            @Header("uid") String uid,
            @Query("name") String empresa);
}
