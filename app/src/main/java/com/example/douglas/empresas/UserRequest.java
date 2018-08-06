package com.example.douglas.empresas;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Douglas on 03/08/2017.
 */

public class UserRequest implements Serializable {

    /** UserRequest serão os objetos que armazenarão a respota do servidor com o acess-token, client e uid
     */

    @SerializedName("access-token")
    private String accessToken;

    @SerializedName("client")
    private String client;

    @SerializedName("uid")
    private String uid;

    public UserRequest(String acessToken, String client, String uid) {
        this.accessToken = acessToken;
        this.client = client;
        this.uid = uid;
    }

    public String getAcessToken() {
        return accessToken;
    }

    public void setAcessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
