package com.example.douglas.empresas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by Douglas on 04/08/2017.
 */

public class AdapterEmpresa extends BaseAdapter {

    private ArrayList<Empresa> empresas;
    private LayoutInflater layoutInflater;
    private Context context;

    /** É criado o adpater para a ListView, recebendo o array de empresas e o contexto da activity
    */
    public AdapterEmpresa(ArrayList<Empresa> empresas, Context context){
        this.context = context;
        this.layoutInflater = (LayoutInflater.from(context));
        this.empresas = empresas;
    }

    @Override
    public int getCount() {
        return empresas.size();
    }

    @Override
    public Object getItem(int position) {
        return empresas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /** A view é inflada com o layout empresa.xml, enviando o o enterprise_name
    * enterprise_type e enterprise_country com as posicoes das empresas no Array
     * assim, o objeto empresa recupera a informação na posicao, setando-as nos componentes da ListView.
    */

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = layoutInflater.inflate(R.layout.empresa,null);

        Empresa empresa = empresas.get(position);


        TextView enterpriseName;
        enterpriseName = (TextView) view.findViewById(R.id.enterprise_name);
        enterpriseName.setText(empresa.getEnterpriseName());

        TextView enterpriseType;
        enterpriseType = (TextView) view.findViewById(R.id.enterprise_type);
        enterpriseType.setText(empresa.getEnterpriseType().getEnterprise_type_name());

        TextView enterpriseCountry;
        enterpriseCountry = (TextView) view.findViewById(R.id.enterprise_country);
        enterpriseCountry.setText(empresa.getCountry());

        return view;
    }


}

