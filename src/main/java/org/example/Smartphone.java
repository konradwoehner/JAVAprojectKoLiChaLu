package org.example;

public class Smartphone{

    //Attribute
    private String modell, farbe, gravur;
    private int speicher, ram;
    private double preis;


    //Konstruktor
    public Smartphone(String modell, String farbe, String gravur, int speicher, int ram, double preis) {
        this.modell = modell;
        this.farbe = farbe;
        this.gravur = gravur;
        this.speicher = speicher;
        this.ram = ram;
        this.preis = preis;
    }

    //Methoden
    public String ausgeben() {
        return this.modell + ", " + farbe + ", " + speicher + "GB, " + ram + "GB, " + gravur + ", " + preis + "€.";
    }

    public double getPreis() {
        return preis;
    }

    public String getFarbe() {
        return farbe;
    }
}