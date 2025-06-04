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
import com.example.applistacursos.model.Pessoa;

public class MainActivity extends AppCompatActivity {
Pessoa pessoa;
Pessoa outraPessoa;

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
        pessoa = new Pessoa();

        pessoa.setPrimeiroNome("Magno");
        pessoa.setSobrenome("Santos");
        pessoa.setCursoDesejado("Desenvolvimento de Sistemas");
        pessoa.setTelefone("99-9999-9999");

       /*outraPessoa = new Pessoa();
        outraPessoa.setPrimeiroNome("Guilherme");
        outraPessoa.setSobrenome("Ferreira");
        outraPessoa.setCursoDesejado("Jogos");
        outraPessoa.setTelefone("88-8888-8888");

        primeiroNome = findViewById(R.id.primeironome);

        sobrenome = findViewById(R.id.sobrenome);

        nomeCurso = findViewById(R.id.nomecurso);

        telefone = findViewById(R.id.telefone);
        */
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
            public void onClick(View v) {
                pessoa.setPrimeiroNome(primeiroNome.getText().toString());
                pessoa.setSobrenome(sobrenome.getText().toString());
                pessoa.setCursoDesejado(nomeCurso.getText().toString());
                pessoa.setTelefone(telefone.getText().toString());

                Toast.makeText(MainActivity.this, "Dados salvos: " + pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });
        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiroNome.setText(" ");
                sobrenome.setText(" ");
                nomeCurso.setText(" ");
                telefone.setText(" ");
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