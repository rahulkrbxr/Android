package com.example.androidtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

//        Toast.makeText(getApplicationContext(), "Namaste World", Toast.LENGTH_SHORT).show();

        Toast toast = Toast.makeText(getApplicationContext(), "Namaste, earth", Toast.LENGTH_SHORT);
        toast.setMargin(500, 50);
        toast.show();

    }
}