package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AdicionarAbastecimento extends AppCompatActivity {

    private EditText campoKm;

    private EditText campoLitros;

    private EditText campoData;

    private Spinner spinnerPosto;

    private Button confirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);

        campoKm = (EditText) findViewById(R.id.campoKm);
        campoLitros = (EditText) findViewById(R.id.campoLitros);
        campoData = (EditText) findViewById(R.id.campoData);
        spinnerPosto = (Spinner) findViewById(R.id.spinnerPosto);
        confirmar = (Button) findViewById(R.id.confirmar);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), VisualizarAbastecimento.class));
            }
        });
    }
}
