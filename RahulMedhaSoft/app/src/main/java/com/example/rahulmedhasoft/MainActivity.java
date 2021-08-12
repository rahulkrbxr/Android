package com.example.rahulmedhasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayoutLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Bundle bundle = getIntent().getExtras();
//        String value1 = bundle.getString("value1");
//        String value2 = bundle.getString("value2");
//
//        Toast.makeText(this, "Username: " + value1 + "\n" + "Password: " +  value2, Toast.LENGTH_SHORT).show();

        Toast.makeText(getApplicationContext(), "Main Activity Page", Toast.LENGTH_SHORT).show();

        linearLayoutLogOut = findViewById(R.id.logout);
        linearLayoutLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("userLoginDetails", 0);
                preferences.edit().clear().apply();
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });
    }
}