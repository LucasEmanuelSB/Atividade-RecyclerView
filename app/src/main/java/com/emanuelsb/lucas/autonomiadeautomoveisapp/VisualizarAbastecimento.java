package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class VisualizarAbastecimento extends AppCompatActivity {

    private AbastecimentoAdapter abastecimentoAdapter;
    private RecyclerView rvAbastecimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_abastecimento);

        Abastecimento.listaAbastecimentos =
        rvAbastecimento = (RecyclerView)findViewById(R.id.rvAbastecimento);
        rvAbastecimento.setLayoutManager(new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvAbastecimento.setAdapter(new AbastecimentoAdapter(Abastecimento.listaAbastecimentos, this));
    }

    @Override
    public void onResume(){
        super.onResume();
        if(abastecimentoAdapter != null) {
            abastecimentoAdapter.notifyDataSetChanged();
        }
    }


}