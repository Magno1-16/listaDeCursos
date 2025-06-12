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

public class MainActivity extends AppCompatActivity {
Pessoa pessoa;

    Spinner spinner;
    EditText primeiroNome;
    EditText sobrenome;
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

        btnfinalizar = findViewById(R.id.btnfinalizar);
        btnlimpar = findViewById(R.id.btnlimpar);
        btnsalvar = findViewById(R.id.btnsalvar);

        //primeiroNome.setText(pessoa.getPrimeiroNome());
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
        });
        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                primeiroNome.setText(" ");
                sobrenome.setText(" ");
                telefone.setText(" ");
                spinner.setSelection(0);
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