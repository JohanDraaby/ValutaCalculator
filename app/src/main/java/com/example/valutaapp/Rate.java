package com.example.valutaapp;

public class Rate {
    String name;
    Double spotRate;

    public Rate(String _name, Double _spotRate){
        name = _name;
        spotRate = _spotRate;
    }

    public String getName() {
        return name;
    }

    public Double getSpotRate() {
        return spotRate;
    }
}
