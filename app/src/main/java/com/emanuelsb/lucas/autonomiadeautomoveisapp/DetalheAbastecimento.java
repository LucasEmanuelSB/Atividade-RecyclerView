package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheAbastecimento extends AppCompatActivity {

    private TextView tvKm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_abastecimento);
        tvKm = (TextView) findViewById(R.id.tvKm);
        tvKm.setText( getIntent().getStringExtra("km") );
    }

}
