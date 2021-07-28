package com.example.androidservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonStart, buttonStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);

//        start = findViewById(R.id.buttonStart);
//        stop = findViewById(R.id.buttonStop);
//
//        start.setOnClickListener((View.OnClickListener) this);
//        stop.setOnClickListener((View.OnClickListener) this);
//        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonStart:
                startService(new Intent(this, MyService.class));
                break;

            case R.id.buttonStop:
                stopService(new Intent(this, MyService.class));
                break;
        }
    }
}