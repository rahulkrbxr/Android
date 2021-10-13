package com.example.cookies;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView menuItem1 = findViewById(R.id.menu_item_1);
        Log.i("MainActivity1.java", menuItem1.getText().toString());

        // Find second menu item TextView and print the text to the logs
        TextView menuItem2 = findViewById(R.id.menu_item_2);
        Log.i("MainActivity1.java", menuItem2.getText().toString());

        // Find third menu item TextView and print the text to the logs
        TextView menuItem3 = findViewById(R.id.menu_item_3);
        Log.i("MainActivity1.java", menuItem3.getText().toString());
    }
}
