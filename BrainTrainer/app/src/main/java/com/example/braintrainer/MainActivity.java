    package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    ArrayList<Integer> answer = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    TextView resultTextView;
    int score = 0;
    int numberOfQuestions = 0;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;

    public void playAgain(View view) {

    }

    public void chooseAnswer(View view) {
//        Log.i("Selected ", view.getTag().toString());
        if ( Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()) ) {
            resultTextView.setText("Correct!");
            score++;
        } else {
            resultTextView.setText("Wrong :(");
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        resultTextView.setVisibility(View.VISIBLE);
        newQuestion();
    }

    public void start(View view) {
        goButton.setVisibility(View.INVISIBLE);
    }

    public void newQuestion() {
        Random random = new Random();
        int a = random.nextInt(21);
        int b = random.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = random.nextInt(4);

        answer.clear();

        for(int i=0; i<4; i++) {
            if(i == locationOfCorrectAnswer) {
                answer.add(a + b);
            } else {
                int wrongAnswer = random.nextInt(41);
                while(wrongAnswer == a+b) {
                    wrongAnswer = random.nextInt(41);
                }

                answer.add(wrongAnswer);
            }
        }

        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = findViewById(R.id.goButton);
        sumTextView = findViewById(R.id.sumTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setVisibility(View.INVISIBLE);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);

        newQuestion();

        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Done!");
            }
        }.start();

    }
}