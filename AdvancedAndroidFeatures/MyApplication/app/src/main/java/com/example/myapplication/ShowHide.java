package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowHide extends AppCompatActivity {

    TextView helloTextView;

    public void show(View view) {
        helloTextView.setVisibility(View.VISIBLE);
    }

    public void hide(View view) {
        helloTextView.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hide);

        helloTextView = findViewById(R.id.helloTextView);

//        Button hide = findViewById(R.id.hide);
//        hide.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                helloTextView.setVisibility(View.INVISIBLE);
//            }
//        });

//        Button show = findViewById(R.id.show);
//        hide.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                helloTextView.setVisibility(View.VISIBLE);
//            }
//        });


    }
}