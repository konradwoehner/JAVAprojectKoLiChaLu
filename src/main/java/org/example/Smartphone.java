package org.example;

public class Smartphone{

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

    public void ausgeben(){
        System.out.println(modell + ", " + farbe + ", " + speicher + "GB, " + ram + "GB, " + gravur + ", " + preis + "€");
    }

    }
