package com.example.rahulmedhasoft;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rahulmedhasoft.database.DataBaseHelper;
import com.example.rahulmedhasoft.entity.StudentInfo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AttendanceListActivity extends AppCompatActivity {

    ArrayList<StudentInfo> studentList = new ArrayList<>();
    ArrayList<StudentInfo> studentArrayList = new ArrayList<>();
    public static String TotnnoClasses="";

    ListView listViewStudentsDetails = findViewById(R.id.listViewStudentsDetails);

    DetailsAdaptor studentListAdaptor;

    TextView studentName, fatherName, motherName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_row_adaptor);
        DataBaseHelper db = new DataBaseHelper(this);
        ListView lv = findViewById(R.id.listViewStudentsDetails);
//        ListAdapter adapter = new SimpleAdapter(DetailsAdaptor.this, studentList, R.layout.list_row, new String[]{"BeneficieryName"}, new int[]{R.id.studentName});
//        lv.setAdapter(adapter);
    }

    public void searchStdList() {
        DataBaseHelper helper = new DataBaseHelper(getApplicationContext());
        studentList = helper.getStudentDetails();
        studentArrayList = studentList;
        Parcelable state = listViewStudentsDetails.onSaveInstanceState();
        if (studentList.size() > 0) {
            studentListAdaptor = new DetailsAdaptor(AttendanceListActivity.this, studentList);
            listViewStudentsDetails.setAdapter(studentListAdaptor);
            studentListAdaptor.notifyDataSetChanged();
            listViewStudentsDetails.setAdapter(studentListAdaptor);
        }
    }
}
