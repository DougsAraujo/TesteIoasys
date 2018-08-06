package com.example.douglas.empresas;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Douglas on 04/08/2017.
 */

public class ListaEmpresas implements Serializable {

    /*
        ListaEmpresas foi necessária para realizar o Array das empresas que são geradas através da respota;
        Assim, irá retornan o a lista com os dados necessários.
     */

    @SerializedName("enterprises")
    private ArrayList<Empresa> lista;

    public ListaEmpresas() {
        lista = new ArrayList<Empresa>();
    }

    public ArrayList<Empresa> getEmpresaLista() {
        return lista;
    }

    public void setEnterpriseList(ArrayList<Empresa> list) {
        this.lista = list;
    }

    @Override
    public String toString() {
        String empresas="";
        for (Empresa e: lista) {
            empresas = empresas + e.getEnterpriseName()+ "\n";
        }

        return empresas;
    }




}
