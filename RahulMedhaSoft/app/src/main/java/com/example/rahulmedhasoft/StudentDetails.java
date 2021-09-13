package com.example.rahulmedhasoft;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentDetails extends AppCompatActivity {

    public String diseCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

//        Intent i =getIntent();
//        diseCode = i.getStringExtra("UserDiseCode");
//        finish();
//        Toast.makeText(getApplicationContext(), "DiseCode: " + diseCode, Toast.LENGTH_SHORT).show();

        ListView listViewStudents = findViewById(R.id.listViewStudents);

        ArrayList<String> country = new ArrayList<>();
        country.add("India");
        country.add("Greece");
        country.add("UK");
        country.add("Germany");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, country);

        listViewStudents.setAdapter(arrayAdapter);

    }
}