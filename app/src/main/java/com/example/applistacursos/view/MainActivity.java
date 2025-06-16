package com.example.applistacursos.view;


import android.app.Activity;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.applistacursos.R;
import com.example.applistacursos.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    Pessoa pessoa;
    PessoaController controller;

Pessoa pessoa;


    Spinner spinner;
    EditText primeiroNome;

    EditText segundoNome;
    EditText telefone_contato;
    String selectedItem;
    Spinner spinner;

    EditText sobrenome;
    EditText telefone;


    Button limpar;
    Button salvar;
    Button finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
appListaCurso_spinner
        pessoa = new Pessoa();
        controller = new PessoaController(this);
        controller.buscar(pessoa);
        controller.toString();

        primeiroNome = findViewById(R.id.primeironome);
        segundoNome = findViewById(R.id.sobrenome);
        telefone_contato = findViewById(R.id.telefone);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_lista, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        class spinnerAct extends Activity implements AdapterView.OnItemSelectedListener {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        }

        primeiroNome = findViewById(R.id.primeironome);
        sobrenome = findViewById(R.id.sobrenome);
        telefone = findViewById(R.id.telefone);


        spinner = findViewById(R.id.nomecurso);

        limpar = findViewById(R.id.btnlimpar);
        salvar = findViewById(R.id.btnsalvar);
        finalizar = findViewById(R.id.btnfinalizar);


        primeiroNome.setText(pessoa.getPrimeiroNome());
        segundoNome.setText(pessoa.getSobrenome());
        telefone_contato.setText(pessoa.getTelefone());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.cursos, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        if (pessoa.getCursoDesejado() != null && !pessoa.getCursoDesejado().isEmpty()) {
            int spinnerPosition = adapter.getPosition(pessoa.getCursoDesejado());
            spinner.setSelection(spinnerPosition);
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = (String) parent.getItemAtPosition(position);

                Toast.makeText(getBaseContext(), "Selecionado" + selectedItem, Toast.LENGTH_SHORT).show();
              
        sobrenome.setText(pessoa.getSobrenome());
        telefone.setText(pessoa.getTelefone());

        btnsalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(primeiroNome.getText().toString());
                pessoa.setSobrenome(sobrenome.getText().toString());

                pessoa.setTelefone(telefone.getText().toString());
                Toast.makeText(MainActivity.this, "Dados salvos: ", Toast.LENGTH_LONG).show();

            }

            @Override

            public void onNothingSelected(AdapterView<?> parent) {

            public void onClick(View v) {
                primeiroNome.setText(" ");
                sobrenome.setText(" ");
                telefone.setText(" ");
                spinner.setSelection(0);

            }

            });

                limpar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        primeiroNome.setText("");
                        segundoNome.setText("");
                        telefone_contato.setText("");
                        spinner.setSelection(0);
                        controller.limpar();

                        Toast.makeText(MainActivity.this, "Dados limpos!", Toast.LENGTH_SHORT).show();
                    }
                });
                salvar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pessoa.setPrimeiroNome(primeiroNome.getText().toString());
                        pessoa.setSobrenome(segundoNome.getText().toString());
                        pessoa.setCursoDesejado(spinner.getSelectedItem().toString());
                        pessoa.setTelefone(telefone_contato.getText().toString());
                        pessoa.setCursoDesejado(selectedItem);

                        Toast.makeText(MainActivity.this, "Dados salvos!" + pessoa.toString(), Toast.LENGTH_SHORT).show();
                        controller.salvar(pessoa);

                    }
                });
                finalizar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        Toast.makeText(MainActivity.this, "Adeus!!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
