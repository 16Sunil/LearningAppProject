package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class frontpage extends AppCompatActivity {
    private Button button;
    CardView study;
    CardView web;
    CardView domain;
    CardView question;
    CardView chart;
    CardView announcement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        button=findViewById(R.id.button);
        study=(CardView) findViewById(R.id.study);
        web=(CardView) findViewById(R.id.web);
        domain=(CardView) findViewById(R.id.domain);
        question=(CardView) findViewById(R.id.question);
        chart=(CardView) findViewById(R.id.chart);
        announcement=(CardView) findViewById(R.id.announcement);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
            }
        });

        study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),secondpage.class);
                startActivity(intent);


            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://cutm.ac.in/"));
                startActivity(intent);

            }
        });
        domain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),thirdpage.class);
                startActivity(intent);


            }
        });
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sanfoundry.com/master-computer-applications-questions-answers/"));
                startActivity(intent);

            }
        });
        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://chat.openai.com/"));
                startActivity(intent);

            }
        });
        announcement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplicationContext(),announcement.class);
                startActivity(intent);
            }
        });
    }
}