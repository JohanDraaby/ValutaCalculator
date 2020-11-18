package com.example.valutaapp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class MockCurrency implements CurrencyDAO{


    @Override
    public List<Rate> getRates(String base) {
        ArrayList<Rate> currencyList = new ArrayList<>();

        currencyList.add(new Rate("DKK", 1.0));
        currencyList.add(new Rate("USD", 2.0));
        currencyList.add(new Rate("EUR", 3.0));
        currencyList.add(new Rate("JPY", 4.1));

        return currencyList;
    }

    public List<String> mockCurrency(String _name, Double _value) {
        ArrayList<Rate> listCurrencies = (ArrayList<Rate>) getRates("");
        ArrayList<String> conversionRates = new ArrayList<>();

        Double baseValue = null;

        for (int i = 0; i < listCurrencies.size(); i++) {
            if (_name.equals(listCurrencies.get(i).getName())) {
                baseValue = listCurrencies.get(i).spotRate;
                listCurrencies.remove(listCurrencies.get(i));
            }
        }

        for (int i = 0; i < listCurrencies.size(); i++) {
            if (!_name.equals(listCurrencies.get(i).name))
                conversionRates.add(listCurrencies.get(i).name + "\n" + (_value * (listCurrencies.get(i).getSpotRate() / baseValue)));
        }

        return conversionRates;
    }

    public ArrayList<String> getCurrenciesName() {
        ArrayList<Rate> listCurrencies = (ArrayList<Rate>) getRates("");
        ArrayList<String> currencyNames = new ArrayList<>();

        for (int i = 0; i < listCurrencies.size(); i++) {
            currencyNames.add(listCurrencies.get(i).name);
        }

        return currencyNames;
    }
}
