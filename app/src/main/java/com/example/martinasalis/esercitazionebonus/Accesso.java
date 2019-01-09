package com.example.martinasalis.esercitazionebonus;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Accesso extends AppCompatActivity {

    Utente utente;
    TextView risposta;
    Button indietro;
    List<Utente> utenti = new ArrayList<>();
    String nameUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accesso);

        risposta = (TextView) findViewById(R.id.risposta);
        indietro = (Button) findViewById(R.id.indietro);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(MainActivity.UTENTE_EXTRA);


        if(obj instanceof Utente)
        {
            utente = (Utente)obj;
        }
        else{
            utente = new Utente();
        }

        utenti.add(new Utente("Francesco","casa"));
        utenti.add(new Utente("Martina","cane"));
        utenti.add(new Utente("Luca","topo"));

        if (login()) {
            risposta.setText("Benvenuto " + nameUser);
        } else {
            risposta.setTextColor(Color.RED);
            risposta.setText("Accesso Negato!");
        }



        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accesso = new Intent(Accesso.this, MainActivity.class);
                startActivity(accesso);
            }
        });
    }

    private boolean login () {
        for (int i=0; i<utenti.size(); i++) {
            if (utenti.get(i).getUsername().equals(utente.getUsername()) &&
                    utenti.get(i).getPassword().equals(utente.getPassword())) {
                nameUser = utenti.get(i).getUsername();
                return true;
            }
        }
        return false;
    }
}
