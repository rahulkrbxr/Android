package com.example.rahulmedhasoft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.loginButton);

        Toast.makeText(getApplicationContext(), "Login Page", Toast.LENGTH_SHORT).show();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

                //abhinavkumar9315@gmail.com
//                http://localhost:58639/WebServiceAPI.asmx?op=SchoolLogin
            }
        });

    }
}


//import androidx.appcompat.app.AppCompatActivity;
//
//public class login extends AppCompatActivity {
//
//    Button loginButton = findViewById(R.id.loginButton);
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(login.this, MainActivity.class);
//                intent.putExtra("value1", "admin");
//                intent.putExtra("value2", "admin@123");
//                startActivity(intent);
//            }
//        });
//
//    }
//}
