package com.example.listexample;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listview;
Spinner spinner;

AutoCompleteTextView actxview;
ArrayList<String> arrName = new ArrayList<>();
ArrayList<String> arrID = new ArrayList<>();

ArrayList<String> arrLanguages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        spinner = findViewById(R.id.spinner);
        actxview = findViewById(R.id.autocomplete);
        arrName.add("ram");
        arrName.add("shyam");
        arrName.add("hari");
        arrName.add("sita");
        arrName.add("gita");
        arrName.add("rita");
        arrName.add("sita");
        arrName.add("gita");
        arrName.add("rita");
        arrName.add("sita");
        arrName.add("gita");
        arrName.add("rita");
        arrName.add("sita");
        arrName.add("gita");
        arrName.add("rita");
        arrName.add("sita");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrName);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(MainActivity.this, "clicked first item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        arrID.add("1");
        arrID.add("2");
        arrID.add("3");
        arrID.add("4");
        arrID.add("5");
        arrID.add("6");
        arrID.add("7");
        arrID.add("8");
        arrID.add("9");
        arrID.add("10");
        arrID.add("11");
        arrID.add("12");
        arrID.add("13");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrID);

        spinner.setAdapter(spinnerAdapter);


        arrLanguages.add("Java");
        arrLanguages.add("Kotlin");
        arrLanguages.add("Python");
        arrLanguages.add("Dart");
        arrLanguages.add("C++");
        arrLanguages.add("C#");
        arrLanguages.add("JavaScript");
        arrLanguages.add("TypeScript");
        arrLanguages.add("Swift");
        arrLanguages.add("Go");
        arrLanguages.add("Ruby");
        arrLanguages.add("Rust");
        arrLanguages.add("PHP");
        arrLanguages.add("HTML");
        arrLanguages.add("CSS");

        ArrayAdapter<String> actxAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrLanguages);
        actxview.setAdapter(actxAdapter);
        actxview.setThreshold(1);
    }
}