package com.example.learningapp.model;

import com.example.learningapp.R;

import java.util.ArrayList;
import java.util.List;

public class GridModelList {
    public ArrayList<GridArrayList> studyMaterialList(){

        ArrayList<GridArrayList> list=new ArrayList<>();
        list.add(new GridArrayList(R.drawable.react,"React"));
        list.add(new GridArrayList(R.drawable.bootstrap,"BootStrap"));
        list.add(new GridArrayList(R.drawable.c,"C"));
        list.add(new GridArrayList(R.drawable.cplus,"C++"));
        list.add(new GridArrayList(R.drawable.css,"CSS"));
        list.add(new GridArrayList(R.drawable.html,"HTML"));
        list.add(new GridArrayList(R.drawable.java,"JAVA"));
        list.add(new GridArrayList(R.drawable.mysql,"MYSQL"));
        list.add(new GridArrayList(R.drawable.oracle,"ORACLE"));
        list.add(new GridArrayList(R.drawable.php,"PHP"));
        list.add(new GridArrayList(R.drawable.python,"PYTHON"));




        return list;
    }
}
