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

        Button btnAdd = (Button) findViewById(R.id.addButton3);
        Button btnSub = (Button) findViewById(R.id.subButton);
        Button btnProduct = (Button) findViewById(R.id.productButton);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(firstNum.getText().toString());
                double num2 = Double.parseDouble(secondNum.getText().toString());
                double ans = num1 + num2;
                String sum = Double.toString(ans);

//                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
//                intent.putExtra("SUM", num1 + " + " + num2 + " = " + (num1+num2));
//                intent.putExtra("SUM",num1+" + "+num2+" = "+(num1+num2));

                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("Sum", sum);

                startActivity(intent);
            }
        });


        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(firstNum.getText().toString());
                double num2 = Double.parseDouble(secondNum.getText().toString());
                double ans = num1 - num2;
                String sub = Double.toString(ans);

                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("Sub", sub);

                startActivity(intent);
            }
        });


        btnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1 = Double.parseDouble(firstNum.getText().toString());
                double num2 = Double.parseDouble(secondNum.getText().toString());
                double ans = num1 * num2;
                String product = Double.toString(ans);

                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("Product", product);

                startActivity(intent);
            }
        });

    }
}