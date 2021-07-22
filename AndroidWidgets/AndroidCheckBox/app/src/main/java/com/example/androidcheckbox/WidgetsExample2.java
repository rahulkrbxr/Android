package com.example.androidcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class WidgetsExample2 extends AppCompatActivity {

    CheckBox burger, momo, samosa, tea, coffee;
    Button payButton;
    int totalAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_example2);

        TextView textView = findViewById(R.id.textView);
        TextView textView2 = findViewById(R.id.textView2);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("name");
        String method = extras.getString("method");

        textView.setText(name + ", tick to order?");

        burger = findViewById(R.id.checkBox1);
        momo = findViewById(R.id.checkBox2);
        samosa = findViewById(R.id.checkBox3);
        tea = findViewById(R.id.checkBox4);
        coffee = findViewById(R.id.checkBox5);

        payButton = findViewById(R.id.button3);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(burger.isChecked()) {
                    totalAmount += 35;
                }
                if(momo.isChecked()) {
                    totalAmount += 20;
                }
                if(samosa.isChecked()) {
                    totalAmount += 20;
                }
                if(tea.isChecked()) {
                    totalAmount += 10;
                }
                if(coffee.isChecked()) {
                    totalAmount += 15;
                }

                textView2.setText("Total amount: Rs." + Integer.toString(totalAmount));
                Toast.makeText(getApplicationContext(), "Bill: Rs." + Integer.toString(totalAmount), Toast.LENGTH_SHORT).show();

                v.setOnClickListener(null);
            }

        });

//        textView2.setText("Total amount: Rs." + Integer.toString(totalAmount));
//        Toast.makeText(getApplicationContext(), "Bill: Rs." + Integer.toString(totalAmount), Toast.LENGTH_SHORT).show();

        if(totalAmount == 0)
            textView2.setText("Please, choose your items");

    }
}