package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SchoolTimer extends AppCompatActivity {

    TextView schoolTimerCounterTextView;
    SeekBar schoolTimerSeekBar;
    boolean counterIsActive = false;
    Button schoolTimerGoButton;
    CountDownTimer countDownTimer;

    public void resetTimer() {
        schoolTimerSeekBar.setProgress(30);
        schoolTimerCounterTextView.setText("0:30");
        schoolTimerSeekBar.setEnabled(true);
        schoolTimerGoButton.setText("Go!");
        counterIsActive = false;
        countDownTimer.cancel();
    }

    public void buttonClicked(View view) {

        if(counterIsActive) {
            resetTimer();
        } else {
            counterIsActive = true;
            schoolTimerSeekBar.setEnabled(false);
            schoolTimerGoButton = findViewById(R.id.schoolTimerGoButton);
            schoolTimerGoButton.setText("Stop!");

            countDownTimer = new CountDownTimer(schoolTimerSeekBar.getProgress()*1000 + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) (millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
//                Log.i("Finished", "Timer done!");
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.air_horn);
                mediaPlayer.start();
                resetTimer();
            }
        }.start();
        }
    }

    public void updateTimer(int secondsLeft) {
        int minutes = secondsLeft/60;
        int seconds = secondsLeft - (minutes*60);

        String secondString = Integer.toString(seconds);
        if(seconds < 10) {
            secondString = "0" + Integer.toString(seconds);
        }

        schoolTimerCounterTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_timer);

        schoolTimerSeekBar = findViewById(R.id.schoolTimerSeekBar);
        schoolTimerCounterTextView = findViewById(R.id.schoolTimerCounterTextView);

        schoolTimerSeekBar.setMax(600);
        schoolTimerSeekBar.setProgress(30);

        schoolTimerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}