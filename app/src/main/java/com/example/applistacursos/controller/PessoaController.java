package com.example.applistacursos.controller;
import android.util.Log;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.example.applistacursos.model.Pessoa;
public class PessoaController {
    @NonNull
    @Override
    public String toString() {
        Log.d("mvc_Controller", "controller iniciado");
        return super.toString();
    }

    public void limpar(EditText primeiroNome, EditText sobrenome, EditText nomeCurso, EditText telefone){
        Log.d("mvc_Controller", "dados limpos");
        primeiroNome.setText(" ");
        sobrenome.setText(" ");
        nomeCurso.setText(" ");
        telefone.setText(" ");
    }
    public void salvar(EditText primeiroNome, EditText sobrenome, EditText nomeCurso, EditText telefone){
        Pessoa pessoa = new Pessoa(primeiroNome.getText().toString(), sobrenome.getText().toString(), nomeCurso.getText().toString(), telefone.getText().toString());
        Log.d("mvc_Controller", "dados salvos: " + pessoa.toString());
    }
}
