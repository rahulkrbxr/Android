package com.example.rahulmedhasoft;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rahulmedhasoft.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        DataBaseHelper db = new DataBaseHelper(this);
        ArrayList<ArrayList<String>> studentList = db.getStudentDetails();
        ListView lv = findViewById(R.id.listViewStudents);
        ListAdapter adapter = new SimpleAdapter(DetailsActivity.this, studentList, R.layout.list_row, new String[]{"BeneficieryName"}, new int[]{R.id.studentName});
        lv.setAdapter(adapter);
    }
}
