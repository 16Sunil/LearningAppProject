package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.learningapp.design.GridCustomAdapter;
import com.example.learningapp.model.GridModelList;

public class secondpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);

        RecyclerView recyclerView=findViewById(R.id.recycle);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        GridCustomAdapter adapter=new GridCustomAdapter(this,new GridModelList().studyMaterialList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}