package com.example.douglas.empresas;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Douglas on 02/08/2017.
 */

public class User {

    /** Os objetos do tipo User, serão utilizados para armazenar o login do usuário.
     */

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
