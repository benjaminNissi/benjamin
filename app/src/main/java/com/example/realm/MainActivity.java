package com.example.realm;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button Login;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.Login);
        Register = (Button) findViewById(R.id.Register);
        Register.setOnClickListener((View.OnClickListener) this);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = username.getText().toString();
                String Pass = password.getText().toString();
                if (User.equals("") || Pass.equals("")) {
                    Toast.makeText(getApplicationContext(), "enter your Username and Password", Toast.LENGTH_LONG).show();
                } else if (User.equals("florien") && Pass.equals("12345")) {
                    Toast.makeText(getApplicationContext(), "login successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Music.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "invalid Username or Password ", Toast.LENGTH_LONG).show();

                }

            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, User_Registration.class);
             