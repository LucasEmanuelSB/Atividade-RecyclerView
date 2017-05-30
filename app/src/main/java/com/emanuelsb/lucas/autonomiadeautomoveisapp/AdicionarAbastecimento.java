package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AdicionarAbastecimento extends AppCompatActivity {

    private EditText campoKm;
    private EditText campoLitros;

    private EditText campoDia;
    private EditText campoMes;
    private EditText campoAno;

    private Spinner spinnerPosto;

    private Button confirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);

        campoKm = (EditText) findViewById(R.id.campoKm);
        campoLitros = (EditText) findViewById(R.id.campoLitros);
        campoDia = (EditText) findViewById(R.id.campoDia);
        campoMes = (EditText) findViewById(R.id.campoMes);
        campoAno = (EditText) findViewById(R.id.campoAno);
        spinnerPosto = (Spinner) findViewById(R.id.spinnerPosto);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.postos, android.R.layout.simple_spinner_item);
        spinnerPosto.setAdapter(adapter);

        confirmar = (Button) findViewById(R.id.confirmar);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Abastecimento novoAba = new Abastecimento();
                novoAba.setDia(Integer.parseInt(campoDia.getText().toString()));
                novoAba.setMes(Integer.parseInt(campoMes.getText().toString()));
                novoAba.setAno(Integer.parseInt(campoAno.getText().toString()));
                novoAba.setKm(Integer.parseInt(campoKm.getText().toString()));
                novoAba.setLitros(Integer.parseInt(campoLitros.getText().toString()));
                if(spinnerPosto.getSelectedItem().toString().equals("Texaco")){
                    novoAba.setPosto(R.drawable.logo_texaco);
                } else if(spinnerPosto.getSelectedItem().toString().equals("Shell")){
                    novoAba.setPosto(R.drawable.logo_shell);
                } else if(spinnerPosto.getSelectedItem().toString().equals("Petrobras")){
                    novoAba.setPosto(R.drawable.logo_petrobras);
                } else if(spinnerPosto.getSelectedItem().toString().equals("Ipiranga")){
                    novoAba.setPosto(R.drawable.logo_ipiranga);
                } else {
                    novoAba.setPosto(R.drawable.outros);
                }

                Abastecimento.listaAbastecimentos.add(novoAba);
                startActivity(new Intent(getApplicationContext(), VisualizarAbastecimento.class));
            }
        });
    }
}
