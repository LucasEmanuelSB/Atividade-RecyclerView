package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.emanuelsb.lucas.autonomiadeautomoveisapp.storage.BdHelper;

import java.util.ArrayList;

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
            /*
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
                finish();
                */

                BdHelper bdHelper = new BdHelper( AdicionarAbastecimento.this );

                SQLiteDatabase bd = bdHelper.getWritableDatabase();

                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put("dia", Integer.parseInt(campoDia.getText().toString()));
                values.put("mes", Integer.parseInt(campoMes.getText().toString()));
                values.put("ano", Integer.parseInt(campoAno.getText().toString()));
                values.put("km", Integer.parseInt(campoKm.getText().toString()));
                values.put("litros", Integer.parseInt(campoLitros.getText().toString()));

                if(spinnerPosto.getSelectedItem().toString().equals("Texaco")){
                    values.put("posto",R.drawable.logo_texaco);
                } else if(spinnerPosto.getSelectedItem().toString().equals("Shell")){
                    values.put("posto",R.drawable.logo_shell);
                } else if(spinnerPosto.getSelectedItem().toString().equals("Petrobras")){
                    values.put("posto",R.drawable.logo_petrobras);
                } else if(spinnerPosto.getSelectedItem().toString().equals("Ipiranga")){
                    values.put("posto",R.drawable.logo_ipiranga);
                } else {
                    values.put("posto",R.drawable.outros);
                }

                long newRowId = bd.insert("minha_tabela", null, values);

                Toast.makeText(AdicionarAbastecimento.this, "Salvo com id: "+ newRowId, Toast.LENGTH_LONG).show();
            }
        });
    }

    public ArrayList<Abastecimento> obtemLista(View v){
        BdHelper bdHelper = new BdHelper( this );
        SQLiteDatabase db = bdHelper.getReadableDatabase();
        String[] projecao = {
                "id",
                "dia",
                "mes",
                "ano",
                "km",
                "litros",
                "posto"};

        String where = "id " + " > ?";
        String[] valoresWhere = {  String.valueOf(0) };
        String orderBy = "id DESC";

        Cursor c = db.query(
                "minha_tabela",                         // Tabela
                projecao,                               // Colunas para seleção
                where,                                  // colunas WHERE
                valoresWhere,                           // valores WHERE
                null,                                   // GROUP BY
                null,                                   // FILTER BY
                orderBy                                 // ORDER BY
        );

        ArrayList<Abastecimento> abastecimentos = new ArrayList<>();

        Abastecimento aba = new Abastecimento();

        String resultado = "";
        if(c.moveToFirst()){
            do{
                aba.setDia(c.getInt(0));
                aba.setMes(c.getInt(1));
                aba.setAno(c.getInt(2));
                aba.setKm(c.getInt(3));
                aba.setLitros(c.getInt(4));
                aba.setPosto(c.getInt(5));

                abastecimentos.add(aba);
            } while (c.moveToNext());
        }else{
            Toast.makeText(this, "Vazio", Toast.LENGTH_LONG).show();
        }

        return abastecimentos;
        //Toast.makeText(this, resultado, Toast.LENGTH_LONG).show();

        //db.delete("minha_tabela", where, valoresWhere);
        //db.update("minha_tabela", values, where, valoresWhere);
    }

}
