package com.example.douglas.empresas;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Douglas on 04/08/2017.
 */

public class EmpresaTipo implements Serializable {

    /** EmpresaTipo faz referencia ao nome do tipo da empresa e o seu ID;
     */
    @SerializedName("id")
    private Integer id;

    @SerializedName("enterprise_type_name")
    private String enterprise_type_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterprise_type_name() {
        return enterprise_type_name;
    }

    public void setEnterprise_type_name(String enterprise_type_name) {
        this.enterprise_type_name = enterprise_type_name;
    }

    public EmpresaTipo(Integer id, String enterprise_type_name) {

        this.id = id;
        this.enterprise_type_name = enterprise_type_name;
    }
}
