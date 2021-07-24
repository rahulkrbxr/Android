package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

import java.util.Timer;

public class TimerDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_demo);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("Seconds left ", String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                Log.i("Hey, it's over", "Countdown timer has stopped");
            }
        }.start();

        /*
        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.i("Hey", "A second is passed by");

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(runnable);
        */
    }
}