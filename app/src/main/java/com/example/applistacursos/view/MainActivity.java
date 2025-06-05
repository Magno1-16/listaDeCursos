package com.example.applistacursos.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    PessoaController controller;

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

        controller = new PessoaController();

        primeiroNome = findViewById(R.id.primeironome);
        sobrenome = findViewById(R.id.sobrenome);
        nomeCurso = findViewById(R.id.nomecurso);
        telefone = findViewById(R.id.telefone);

        btnfinalizar = findViewById(R.id.btnfinalizar);
        btnlimpar = findViewById(R.id.btnlimpar);
        btnsalvar = findViewById(R.id.btnsalvar);

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.toString();
                controller.salvar(primeiroNome, sobrenome, nomeCurso, telefone);
                Toast.makeText(MainActivity.this, "Dados salvos: ", Toast.LENGTH_LONG).show();
            }
        });
        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.toString();
                controller.limpar(primeiroNome, sobrenome, nomeCurso, telefone);
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