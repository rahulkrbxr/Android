package com.example.androidcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class WidgetsExample1 extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] paymentMethod = {"Cash", "Rupay", "Visa", "Mastercard", "UPI"};

    EditText personName;
    Spinner paymentSpinner;
    Button buyButton;

    String method;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_example1);

        personName = findViewById(R.id.editTextPersonName);
        paymentSpinner = findViewById(R.id.spinnerPaymentMethod);
        buyButton = findViewById(R.id.buttonBuy);

//        paymentSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paymentMethod);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        paymentSpinner.setAdapter(arrayAdapter);
        paymentSpinner.setOnItemSelectedListener(this);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        method = paymentMethod[position];
//        Toast.makeText(getApplicationContext(), paymentMethod[position], Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    public void WidgetsExample2(View view) {

        String name = personName.getText().toString();
        Intent intent = new Intent(getApplicationContext(), WidgetsExample2.class);
        intent.putExtra("name", name);
        intent.putExtra("method", method);

        startActivity(intent);
    }

}
