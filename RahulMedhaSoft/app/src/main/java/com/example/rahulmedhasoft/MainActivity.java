package com.example.rahulmedhasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rahulmedhasoft.database.WebServiceHelper;
import com.example.rahulmedhasoft.entity.StudentInfo;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    LinearLayout lin_logout;
    LinearLayout lin_home;
    LinearLayout lin_attendane;
    TextView diseCode;
    TextView mobileNo;
    TextView otp;

    String UserDiseCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("userLoginDetails", 0);
        UserDiseCode = sharedPreferences.getString("UserDiseCode", "");
        diseCode = findViewById(R.id.user_dise);
        diseCode.setText("Dise Code: " + UserDiseCode);
        String UserMobileNumber = sharedPreferences.getString("UserMobileNumber", "");
        mobileNo = findViewById(R.id.total_students_mid_day_meal);
        mobileNo.setText("Mobile No: " + UserMobileNumber);
        String UserOtp = sharedPreferences.getString("UserOtp", "");
        otp = findViewById(R.id.total_students);
        otp.setText("OTP: " + UserOtp);

//        Bundle bundle = getIntent().getExtras();
//        String value1 = bundle.getString("value1");
//        String value2 = bundle.getString("value2");
//
//        Toast.makeText(this, "Username: " + value1 + "\n" + "Password: " +  value2, Toast.LENGTH_SHORT).show();

//        Toast.makeText(getApplicationContext(), "Main Activity Page", Toast.LENGTH_SHORT).show();

        lin_logout = findViewById(R.id.lin_logout);
        lin_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("userLoginDetails", 0);
                preferences.edit().clear().apply();
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });

        lin_home = findViewById(R.id.lin_home);
        lin_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
            }
        });

        // display student list
        lin_attendane = findViewById(R.id.lin_attendane);
        lin_attendane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, student_details.class);
                startActivity(i);

                if(UserDiseCode.equals(""))
                    Toast.makeText(getApplicationContext(), "Dise Code not available", Toast.LENGTH_LONG).show();
                else
                    new MarkAttendance().execute();
            }
        });
    }


    private class MarkAttendance extends AsyncTask<String, Void, ArrayList<StudentInfo>> {

        private ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            try {
                if (dialog == null) {
                    dialog = new ProgressDialog(MainActivity.this);

                }
                dialog.setMessage("Fetching results.\nPlease wait...");
                dialog.show();
            }
            catch (Exception e) {
                Toast.makeText(MainActivity.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected ArrayList<StudentInfo> doInBackground(String... strings) {
            return WebServiceHelper.GetStudentList(UserDiseCode);
        }

        @Override
        protected void onPostExecute(ArrayList<StudentInfo> pvmArrayList) {
            super.onPostExecute(pvmArrayList);

            Log.d("Student list :" ,""+pvmArrayList.size());
        }
    }
}