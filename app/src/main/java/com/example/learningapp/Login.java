package com.example.learningapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    String[] cNames={"Student","Faculty"};
    private TextView register;
    private TextView forget;
    Spinner spinner;

    EditText Email,Password;
    Button siginin;
    FirebaseAuth mAuth;
    ProgressBar progress;
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){

            Intent intent=new Intent(getApplicationContext(),frontpage.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        progress=(ProgressBar)findViewById(R.id.progress);
        Email=(EditText) findViewById(R.id.etSinInEmail);
        Password=(EditText)findViewById(R.id.etSinInPassword) ;
        siginin=(Button)findViewById(R.id.btnSignIn) ;
        register=(TextView) findViewById(R.id.tvRegister);
        forget=(TextView) findViewById(R.id.tvForgotPassword);
         spinner =(Spinner)findViewById(R.id.spinner);
         ArrayAdapter<String>adapter=new ArrayAdapter<String>(Login.this, android.R.layout.simple_spinner_item,cNames);
                 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                 spinner.setAdapter(adapter);
                 spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                     @Override
                     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                         String value=parent.getItemAtPosition(position).toString();
                         Toast.makeText(Login.this,value,Toast.LENGTH_SHORT).show();

                     }

                     @Override
                     public void onNothingSelected(AdapterView<?> adapterView) {

                     }
                 });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Signup.class);
                startActivity(intent);
                finish();
            }
        });

        siginin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.setVisibility(view.VISIBLE);
                String email,password;
                email=String.valueOf(Email.getText());
                password=String.valueOf(Password.getText());
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this,"Enter Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progress.setVisibility(view.GONE);
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    Toast.makeText(getApplicationContext(), "Login Success.", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(), frontpage.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });


    }


}