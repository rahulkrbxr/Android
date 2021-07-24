package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MathTable extends AppCompatActivity {

    ListView listView;

    private void mathTableGenerator(int mathTableNumber) {
        ArrayList<String> mathTableContent = new ArrayList<>();

        for(int j=1; j<=10; j++) {
            mathTableContent.add(Integer.toString(j * mathTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MathTable.this, android.R.layout.simple_list_item_1, mathTableContent);

        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_table);

        SeekBar seekBar = findViewById(R.id.mathTableSeekBar);
        listView = findViewById(R.id.mathTableListView);

        int max = 20;
        int currentNumber = 10;

        seekBar.setMax(max);
        seekBar.setProgress(currentNumber);
        mathTableGenerator(currentNumber);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int mathTableNumber;

                if(progress < min) {
                    mathTableNumber = min;
                    seekBar.setProgress(min);
                }else {
                    mathTableNumber = progress;
                }

                Log.i("Table no: ", Integer.toString(mathTableNumber));

                ArrayList<String> mathTableContent = new ArrayList<>();

                for(int j=1; j<=10; j++) {
                    mathTableContent.add(Integer.toString(j * mathTableNumber));
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MathTable.this, android.R.layout.simple_list_item_1, mathTableContent);

                listView.setAdapter(arrayAdapter);

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