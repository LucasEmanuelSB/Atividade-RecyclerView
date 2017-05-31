package com.emanuelsb.lucas.autonomiadeautomoveisapp;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by lucas on 27/05/2017.
 */

public class Abastecimento {

    public static ArrayList<Abastecimento> listaAbastecimentos;

    private int dia;
    private int mes;
    private int ano;
    private int km;
    private int litros;
    private int posto;

    public Abastecimento(int dia, int mes, int ano, int km, int litros, int posto){

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.km = km;
        this.litros = litros;
        this.posto = posto;
    }

    public Abastecimento(){

     }
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public int getPosto() {
        return posto;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }
}
