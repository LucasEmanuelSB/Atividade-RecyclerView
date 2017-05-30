package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Item extends AppCompatActivity{

    private ImageView icone;
    private TextView data;
    private TextView valueKm;
    private TextView valueLitros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        icone = (ImageView) findViewById(R.id.icone);
        data = (TextView) findViewById(R.id.data);
        valueKm = (TextView) findViewById(R.id.valueKm);
        valueLitros = (TextView) findViewById(R.id.valueLitros);
        //icone.setImageResource(getIntent().getIntExtra("posto"));
        data.setText( getIntent().getStringExtra("dia") + "/" + getIntent().getStringExtra("mes") + "/" + getIntent().getStringExtra("ano"));
        valueKm.setText( getIntent().getStringExtra("km"));
        valueLitros.setText( getIntent().getStringExtra("litros"));
    }
}
