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
    String[] country = {"India", "Bangladesh", "Srilanka", "Bhutan", "Nepal", "Other"};
    Spinner spin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);

        //Getting the instance of spinner and applying clickListener on it
        spin = findViewById(R.id.spinner);
//        spin.setOnItemClickListener(this);

        //Creating the array adapter having country list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, country);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on spinner
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

    }

@Override
    // action when an item or nothing is selected
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

        switch (arg0.getId())
        {
            case R.id.spinner:
                //if(position>0){
                Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();

                Log.i("Country", country[position]);
                //}
                break;
        }


    }
@Override
    public void onNothingSelected(AdapterView<?> agr0) {

    }
}