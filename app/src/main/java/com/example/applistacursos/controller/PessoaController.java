package com.example.applistacursos.controller;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import com.example.applistacursos.model.Pessoa;
import com.example.applistacursos.view.MainActivity;

public class PessoaController {

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listaVip";

    SharedPreferences preferences;

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }
    public void salvar(Pessoa pessoa) {
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("nomecurso", pessoa.getCursoDesejado());
        listaVip.putString("telefone", pessoa.getTelefone());
        listaVip.apply();

        Log.d("MVC_controller", "Dados salvos!" + pessoa.toString());
    }
    public Pessoa buscar (Pessoa pessoa){
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobrenome(preferences.getString("sobrenome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("nomecurso", "NA"));
        pessoa.setTelefone(preferences.getString("telefone", "NA"));

        return pessoa;
    }
    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }
    @NonNull
    @Override
    public String toString(){
        Log.d("MVC_Controller", "Controller iniciado");
        return super.toString();
    }
}