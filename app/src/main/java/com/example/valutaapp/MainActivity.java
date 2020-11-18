package com.example.valutaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ArrayList<String> rates;
    ArrayAdapter<String> xAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        Button button = findViewById(R.id.button);


        String[] arraySpinner = new String[] {
                "DKK", "USD", "EUR", "JPY"
        };
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                updateViewList(spinner.getSelectedItem().toString(), Double.valueOf(editText.getText().toString()));
            }
        });

        /*spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateViewList(spinner.getSelectedItem().toString());
            }
        });*/
    }

    public void updateViewList(String _name, Double _value) {
        ListView listView = findViewById(R.id.listView);

        MockCurrency mockCurrency = new MockCurrency();
        rates = (ArrayList<String>)mockCurrency.mockCurrency(_name, _value);

        xAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rates);
        listView.setAdapter(xAdapter);
    }
}