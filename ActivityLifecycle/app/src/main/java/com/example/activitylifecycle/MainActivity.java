package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // load all UI components defined in activity_main.xml
        setContentView(R.layout.activity_main);

        Log.d("Activity Lifecycle", "onCreate invoked");

        Toast.makeText(this, "onCreate invoked", Toast.LENGTH_SHORT).show();
    }

    protected void onStart() {
        super.onStart();
        Log.d("Activity Lifecycle", "onStart invoked");

        Toast.makeText(this, "onStart invoked", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Log.d("Activity Lifecycle", "onResume invoked");

        Toast.makeText(this, "onResume invoked", Toast.LENGTH_SHORT).show();
    }

    protected  void onPause() {
        super.onPause();
        Log.d("Activity Lifecycle", "onPause invoked");

        Toast.makeText(this, "onPause invoked", Toast.LENGTH_SHORT).show();
    }

    protected void onStop() {
        super.onStop();
        Log.d("Activity Lifecycle", "onStop invoked");

        Toast.makeText(this, "onStop invoked", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart() {
        super.onRestart();
        Log.d("Activity Lifecycle", "onRestart invoked");

        Toast.makeText(this, "onRestart invoked", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity Lifecycle", "onDestroy invoked");

        Toast.makeText(this, "onDestroy invoked", Toast.LENGTH_SHORT).show();
    }
}
