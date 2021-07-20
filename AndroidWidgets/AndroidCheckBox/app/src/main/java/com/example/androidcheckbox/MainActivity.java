package com.example.androidcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox pizza, burger, coffee;
    Button buttonOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButtonClick();

    }

    public void addListenerOnButtonClick() {
        pizza = (CheckBox)findViewById(R.id.checkBox1);
        burger = (CheckBox)findViewById(R.id.checkBox2);
        coffee = (CheckBox)findViewById(R.id.checkBox3);

        buttonOrder = (Button)findViewById(R.id.button);

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items");

                if(pizza.isChecked()) {
                    result.append("\nPizza 100Rs");
                    totalAmount += 100;
                }
                if(burger.isChecked()) {

                    result.append("\nBurger 75Rs");
                    totalAmount += 75;
                }
                if(coffee.isChecked()) {
                    result.append("\nCoffee 50Rs");
                    totalAmount += 50;
                }

                result.append(("\nTotal: " + totalAmount + "Rs"));


                //Displaying the message on the toast
                String amount=String.valueOf(totalAmount);
                Log.d("valueinLog",amount);
                Toast.makeText(getApplicationContext(), amount, Toast.LENGTH_LONG).show();

//                Toast toast = Toast.makeText()

                Log.i("Price", result.toString());

            }
        });

    }
}