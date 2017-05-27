package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lucas on 27/05/2017.
 */

public class AbastecimentoHolder extends RecyclerView.ViewHolder {

    private ImageView fotografia;

    private TextView nome;

    private final Context context;

    private Abastecimento objAbastecimento;

    public CarroAbastecimento(View itemView) {
        super(itemView);
        context = itemView.getContext();

        fotografia = (ImageView) itemView.findViewById(R.id.fotografia);
        nome = (TextView) itemView.findViewById(R.id.nome);
        itemView.setOnClickListener(this);

    }

    public void renderizaNovoAbastecimento(Abastecimento aba) {
        this.nome.setText(aba.getNome());
        objAbastecimento = aba;

    }
}
