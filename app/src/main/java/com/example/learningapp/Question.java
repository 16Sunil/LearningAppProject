package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

public class Question extends AppCompatActivity {
    private ListView lv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       lv = findViewById(R.id.lv);
        final String names[] = {"C", "JAVA", "PYTHON", "C++", "HTML", "PHP"};
         ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
         lv.setAdapter(arrayAdapter);
         lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                 String selectedItem= names[position];
                 Toast.makeText(Question.this, "Clicked on: " + selectedItem, Toast.LENGTH_SHORT).show();
             }
         });
    }
}