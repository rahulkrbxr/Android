package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.system.StructTimespec;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view) {
        Log.i("Info", "Button pressed");

        EditText editText = (EditText) findViewById(R.id.editTextNumberDecimal);

        String amountInDollars = editText.getText().toString();

        double amountInDollarsDouble = Double.parseDouble(amountInDollars);

        double amountInRupeesDouble = amountInDollarsDouble * 74.77;

        String amountInRupees = String.format("%.2f", amountInRupeesDouble);

        Log.i("Amount in rupees", amountInRupees);

        Toast.makeText(this, "$" + amountInDollars + " is \u20B9" + amountInRupees +
                " Indian rupees", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}