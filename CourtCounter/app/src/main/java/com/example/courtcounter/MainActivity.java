package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView scoreView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(8);
    }

    public void addThreeForTeamA(View view) {
        scoreView.setText("3");
    }

    public void addTwoForTeamA(View view) {
        scoreView.setText("2");
    }

    public void addOneForTeamA(View view) {
        scoreView.setText("1");
    }

    /**
     * Displays the given score for Team A
     */
    public void displayForTeamA(int score) {
        scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
}