package com.emanuelsb.lucas.autonomiadeautomoveisapp;

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

    private  int litros;

    private String urlImage;

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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}