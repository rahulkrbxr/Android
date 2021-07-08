package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Numbers {
        int number;

        public boolean isTriangular() {
            int x = 1;
            for(int i=1; x<number; i++, x+=i) { }
            if(x == number) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);
            if(squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void testNumber(View view) {

        Log.i("Info", "Button pressed");

        EditText editText = (EditText) findViewById(R.id.editTextNumber);

        String message;

        if(editText.getText().toString().isEmpty()) {
            message = "Please enter a number";
        } else {
            Numbers myNumber = new Numbers();
            myNumber.number = Integer.parseInt(editText.getText().toString());

            message = editText.getText().toString();

            if(myNumber.isSquare() && myNumber.isTriangular()) {
                message += " is square and triangular";
            } else if(myNumber.isSquare()) {
                message += " is square";
            } else if(myNumber.isTriangular()) {
                message += " is triangular";
            } else {
                message += " is neither square nor triangular";
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}