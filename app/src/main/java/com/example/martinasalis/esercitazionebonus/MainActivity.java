package com.example.martinasalis.esercitazionebonus;


import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    TextView nuovoUtente;
    Button accedi;
    Utente utente = new Utente();


    public static final String UTENTE_EXTRA = "com.example.martinasalis.esercitazionebonus.Utente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        accedi = (Button) findViewById(R.id.accedi);
        nuovoUtente = (TextView) findViewById(R.id.nuovoUtente);

        nuovoUtente.setPaintFlags(nuovoUtente.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()) {
                    updateUtente();
                    Intent accesso = new Intent(MainActivity.this,
                            Accesso.class);
                    accesso.putExtra(UTENTE_EXTRA, utente);
                    startActivity(accesso);
                }
            }
        });

    }

    public void updateUtente() {
        utente.setUsername(username.getText().toString());
        utente.setPassword(password.getText().toString());
    }

    private boolean checkInput() {

        int errors = 0;

        if(username.getText() == null || username.getText().length()==0){
            username.setError("Inserisci l'username");
            errors++;
        }
        else{
            username.setError(null);
        }

        if(password.getText() == null || password.getText().length()==0){
            password.setError("Inserisci la password");
            errors++;
        }
        else{
            password.setError(null);
        }

        return errors == 0;

    }
}
