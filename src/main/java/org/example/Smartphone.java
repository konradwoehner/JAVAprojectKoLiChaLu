package org.example;

public class Smartphone {

    //Attribute Elternklasse

    protected String modell, farbe, gravur;
    protected int speicher, ram;
    protected double preis;


    //Konstruktor Elternklasse

    public Smartphone(String modell, String farbe, String gravur, int speicher, int ram, double preis) {
        this.modell = modell;
        this.farbe = farbe;
        this.gravur = gravur;
        this.speicher = speicher;
        this.ram = ram;
        this.preis = preis;
    }


    //Methoden


    public String umformen(){
        String stmodell = modell;
        String stfarbe = farbe;
        String stspeicher = String.valueOf(speicher);
        String stram = String.valueOf(ram);
        String stgravur = gravur;
        String stpreis = String.valueOf(preis);
        return stmodell + stfarbe + stspeicher;
    }

    }
