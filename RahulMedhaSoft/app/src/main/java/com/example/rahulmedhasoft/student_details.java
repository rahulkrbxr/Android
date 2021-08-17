package com.example.rahulmedhasoft;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.rahulmedhasoft.databinding.ActivityStudentDetailsBinding;

import java.util.ArrayList;

public class student_details extends AppCompatActivity {

    ListView listViewStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

         listViewStudent = findViewById(R.id.listViewStudents);

        ArrayList<String> country = new ArrayList<>();
        country.add("India");
        country.add("Pakistan");
        country.add("Nepal");
        country.add("Germany");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, country);

        listViewStudent.setAdapter(arrayAdapter);

        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = position + " " + ((TextView)view).getText().toString();
                Toast.makeText(student_details.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}