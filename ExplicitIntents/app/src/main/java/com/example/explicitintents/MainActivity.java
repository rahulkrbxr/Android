package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String resultedValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstNum = (EditText) findViewById(R.id.firstTextNumber);
        EditText secondNum = (EditText) findViewById(R.id.secondTextNumber);
        ListView listView = findViewById(R.id.listView);

        Button btnAdd = (Button) findViewById(R.id.addButton3);
        Button btnSub = (Button) findViewById(R.id.subButton);
        Button btnProduct = (Button) findViewById(R.id.productButton);

        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Addition");
        arrayList.add("Substraction");
        arrayList.add("Multiplication");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("operation", arrayList.get(position));
//                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(firstNum.getText().toString());
                double num2 = Double.parseDouble(secondNum.getText().toString());
                double ans = num1 + num2;
                String sum = Double.toString(ans);
                resultedValue=sum;

//                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
//                intent.putExtra("SUM", num1 + " + " + num2 + " = " + (num1+num2));
//                intent.putExtra("SUM",num1+" + "+num2+" = "+(num1+num2));

//                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("value", resultedValue);

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
                resultedValue=sub;

//                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("value", resultedValue);

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
                resultedValue=product;
//                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("value", resultedValue);

                startActivity(intent);
            }
        });

    }
}