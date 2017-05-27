package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

    private Button add;

    private Button vizual;

    private TextView autonomia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        add = (Button) findViewById(R.id.add);
        vizual = (Button) findViewById(R.id.vizual);
        autonomia = (TextView) findViewById(R.id.autonomia);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AdicionarAbastecimento.class));
            }
        });

        vizual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), VisualizarAbastecimento.class));
            }
        });

    }
}
