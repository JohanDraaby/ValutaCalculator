package com.example.valutaapp;

import java.util.List;

public interface CurrencyDAO {
    public List<Rate> getRates(String base);
}
