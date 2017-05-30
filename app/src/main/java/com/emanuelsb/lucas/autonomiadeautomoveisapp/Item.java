package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Item extends AppCompatActivity {

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
        String url = getIntent().getStringExtra("url");
        data.setText( getIntent().getStringExtra("data"));
        valueKm.setText( getIntent().getStringExtra("km"));
        valueLitros.setText( getIntent().getStringExtra("litros"));
    }
}
