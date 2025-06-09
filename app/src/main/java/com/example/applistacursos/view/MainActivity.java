package com.example.applistacursos.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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
import com.example.applistacursos.controller.PessoaController;
import com.example.applistacursos.model.Pessoa;

public class MainActivity extends AppCompatActivity {
Pessoa pessoa;
public static final String NOME_PREFERENCES = "pref_listaVip";
SharedPreferences preferences;

    EditText primeiroNome;
    EditText sobrenome;
    EditText nomeCurso;
    EditText telefone;
    Button btnsalvar;
    Button btnlimpar;
    Button btnfinalizar;

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

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        SharedPreferences.Editor listaVip = preferences.edit();
        pessoa = new Pessoa();

        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobrenome(preferences.getString("sobrenome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("CursoDesejado", "NA"));
        pessoa.setTelefone(preferences.getString("telefone", "NA"));

        primeiroNome = findViewById(R.id.primeironome);
        sobrenome = findViewById(R.id.sobrenome);
        nomeCurso = findViewById(R.id.nomecurso);
        telefone = findViewById(R.id.telefone);

        btnfinalizar = findViewById(R.id.btnfinalizar);
        btnlimpar = findViewById(R.id.btnlimpar);
        btnsalvar = findViewById(R.id.btnsalvar);

        primeiroNome.setText(pessoa.getPrimeiroNome());
        sobrenome.setText(pessoa.getSobrenome());
        nomeCurso.setText(pessoa.getCursoDesejado());
        telefone.setText(pessoa.getTelefone());


        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(primeiroNome.getText().toString());
                pessoa.setSobrenome(sobrenome.getText().toString());
                pessoa.setCursoDesejado(nomeCurso.getText().toString());
                pessoa.setTelefone(telefone.getText().toString());
                Toast.makeText(MainActivity.this, "Dados salvos: ", Toast.LENGTH_LONG).show();

               //Utilizado para salvar os arquivos dentro do device explorer
                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("sobrenome", pessoa.getSobrenome());
                listaVip.putString("CursoDesejado", pessoa.getCursoDesejado());
                listaVip.putString("telefone", pessoa.getTelefone());
                listaVip.apply();
            }
        });
        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiroNome.setText(" ");
                sobrenome.setText(" ");
                nomeCurso.setText(" ");
                telefone.setText(" ");

                //Utilizado para apagar os arquivos salvos dentro do device explorer
                listaVip.clear();
                listaVip.apply();
            }
        });
        btnfinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(MainActivity.this, "Adeus!!", Toast.LENGTH_LONG).show();
            }
        });
 

    }
}