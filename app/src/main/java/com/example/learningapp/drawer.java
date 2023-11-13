package com.example.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class drawer extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FirebaseAuth auth;
    TextView textView;
    FirebaseUser user;
    private Button logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

       drawerLayout=findViewById(R.id.drawer);
       navigationView=findViewById(R.id.navigationView);
        toolbar=findViewById(R.id.toolbar);
        auth= FirebaseAuth.getInstance();
       user=auth.getCurrentUser();
        textView=(TextView) findViewById(R.id.textView);
        logout=(Button)findViewById(R.id.button);
        if(user==null){

           Intent intent=new Intent(getApplicationContext(),Login.class);
            startActivity(intent);
            finish();
        }
        else{
            textView.setText(user.getEmail());
        }
        logout.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getApplicationContext(),Login.class);
               startActivity(intent);
                finish();

           }
        });

        //step 1
       setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);

       drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
             int id=item.getItemId();

             if(id==R.id.bookmark){

             }else if(id== R.id.share){

             } else if (id== R.id.rate) {

            } else if (id== R.id.about) {

             } else if (id == R.id.logout) {

            }else{

             }

               return true;
            }
        });

    }
}