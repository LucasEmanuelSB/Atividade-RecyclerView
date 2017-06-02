package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {

    private Button add;

    private Button vizual;

    private TextView autonomia;

    private static int autonomiaAtual = 0;

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

    @Override
    public void onResume(){
        super.onResume();

        int x = 0;
        int y = 0;

        if(autonomiaAtual == 0){

            if(Abastecimento.listaAbastecimentos.size() > 0){
                for(int i = 0; i < Abastecimento.listaAbastecimentos.size(); i++){

                    x = x + Abastecimento.listaAbastecimentos.get(i).getKm();
                    y = y + Abastecimento.listaAbastecimentos.get(i).getLitros();
                }

                autonomiaAtual = x/y;
            }

        } else if(autonomiaAtual > 0) {

            int km = Abastecimento.listaAbastecimentos.get(Abastecimento.listaAbastecimentos.size() -1 ).getKm();
            int litros = Abastecimento.listaAbastecimentos.get(Abastecimento.listaAbastecimentos.size() -1).getLitros();
            autonomiaAtual = autonomiaAtual + km/litros;
        }

        autonomia.setText(Integer.toString(autonomiaAtual));
    }

}
