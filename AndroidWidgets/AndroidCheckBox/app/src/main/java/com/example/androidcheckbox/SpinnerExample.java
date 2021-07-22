package com.example.androidcheckbox;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerExample extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] country = {"Select a country", "India", "Bangladesh", "Srilanka", "Bhutan", "Nepal", "Other"};
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);

        //Getting the instance of spinner and applying clickListener on it
        spinner = findViewById(R.id.spinnerCountry);
//        spinner.setOnItemClickListener(this);

        //Creating the array adapter having country list
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, country);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

@Override
    // action when an item or nothing is selected
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//        switch (parent.getId())
//        {
//            case R.id.spinnerCountry:
//                //if(position>0){
//                Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_SHORT).show();
//
//                Log.i("Country", country[position]);
//                //}
//                break;
//        }

        Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_SHORT).show();

    }
@Override
    public void onNothingSelected(AdapterView<?> agr0) {

    }
}