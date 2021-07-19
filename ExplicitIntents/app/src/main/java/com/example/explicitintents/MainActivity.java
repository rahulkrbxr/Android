package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstNum = (EditText) findViewById(R.id.firstTextNumber);
        EditText secondNum = (EditText) findViewById(R.id.secondTextNumber);
        Button btnAdd = (Button) findViewById(R.id.addButton);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(firstNum.getText().toString());
                int num2 = Integer.parseInt(secondNum.getText().toString());

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
//                intent.putExtra("SUM", num1 + " + " + num2 + " = " + (num1+num2));
                intent.putExtra("SUM",num1+" + "+num2+" = "+(num1+num2));
                startActivity(intent);
            }
        });
    }
}