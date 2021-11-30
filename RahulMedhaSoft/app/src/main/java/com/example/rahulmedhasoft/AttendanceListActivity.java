package com.example.rahulmedhasoft;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
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
    public static String TotnnoClasses = "";

    ListView listViewStudentsDetails;

    DetailsAdaptor studentListAdaptor;

    TextView studentName, fatherName, motherName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        listViewStudentsDetails=findViewById(R.id.listViewStudentsDetails);

//                 DataBaseHelper db = new DataBaseHelper(this);
//        studentList = db.getStudentDetails();
//        ListView lv = findViewById(R.id.listViewStudentsDetails);
//        ListAdapter adapter = new SimpleAdapter(AttendanceListActivity.this, studentList, R.layout.list_row_adaptor, new String[]{"BeneficieryName", "Father Name", "Mother Name"}, new int[]{R.id.studentName, R.id.fatherName, R.id.motherName});
//        lv.setAdapter(adapter);
        searchStdList();
    }

    public void searchStdList() {
        DataBaseHelper helper = new DataBaseHelper(getApplicationContext());
        studentList = helper.getStudentDetails();

//        studentArrayList = studentList;
//        Parcelable state = listViewStudentsDetails.onSaveInstanceState();

        if (studentList.size() > 0) {

            Log.d("Ben name",studentList.get(0).getBeneficieryName());
            studentListAdaptor = new DetailsAdaptor(AttendanceListActivity.this, studentList);
            listViewStudentsDetails.setAdapter(studentListAdaptor);
            studentListAdaptor.notifyDataSetChanged();

//            studentListAdaptor.notifyDataSetChanged();
//            listViewStudentsDetails.setAdapter(studentListAdaptor);
        }
    }
}
