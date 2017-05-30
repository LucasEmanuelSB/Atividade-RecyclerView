package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lucas on 27/05/2017.
 */

public class AbastecimentoHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private ImageView icone;
    private TextView data;
    private TextView valueKm;
    private TextView valueLitros;

    private final Context context;

    private Abastecimento objAbastecimento;

    public AbastecimentoHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();

        icone = (ImageView) itemView.findViewById(R.id.icone);
        data = (TextView) itemView.findViewById(R.id.data);
        valueKm = (TextView) itemView.findViewById(R.id.valueKm);
        valueLitros = (TextView) itemView.findViewById(R.id.valueLitros);
        itemView.setOnClickListener(this);
    }

    public void renderizaNovoAbastecimento(Abastecimento aba) {
        this.icone.setImageResource(aba.getPosto());
        this.data.setText(aba.getDia() + "/" + aba.getMes() + "/" + aba.getAno());
        this.valueKm.setText(aba.getKm());
        this.valueLitros.setText(aba.getLitros());
        objAbastecimento = aba;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        intent =  new Intent(context, Item.class);
        intent.putExtra("posto", objAbastecimento.getPosto());
        intent.putExtra("dia",objAbastecimento.getDia());
        intent.putExtra("mes",objAbastecimento.getMes());
        intent.putExtra("ano",objAbastecimento.getAno());
        intent.putExtra("km", objAbastecimento.getKm());
        intent.putExtra("litros", objAbastecimento.getLitros());
        context.startActivity(intent);
    }
}
