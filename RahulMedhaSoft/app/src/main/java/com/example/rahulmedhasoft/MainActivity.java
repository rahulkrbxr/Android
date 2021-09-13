package com.example.rahulmedhasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
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

    private String userDiseCode="";
    private String userMobileNumber="";
    private String userOtp="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // success in retrieving data from login.java
        Bundle bundle = getIntent().getExtras();
        userDiseCode = bundle.getString("UserDiseCode");
        userMobileNumber = bundle.getString("UserMobileNumber");
        userOtp = bundle.getString("UserOtp");
        finish();
        
        Toast.makeText(getApplicationContext(), userDiseCode + "\n" + userMobileNumber + "\n" + userOtp, Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPreferences = getSharedPreferences("userLoginDetails", 0);
        userDiseCode = sharedPreferences.getString("UserDiseCode", "");
        diseCode = findViewById(R.id.user_dise);
        diseCode.setText("Dise Code: " + userDiseCode);
        String UserMobileNumber = sharedPreferences.getString("UserMobileNumber", "");
        mobileNo = findViewById(R.id.total_students_mid_day_meal);
        mobileNo.setText("Mobile No: " + userMobileNumber);
        String UserOtp = sharedPreferences.getString("UserOtp", "");
        otp = findViewById(R.id.total_students);
        otp.setText("OTP: " + userOtp);

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
                Intent i = new Intent(MainActivity.this, StudentDetails.class);
                i.putExtra("UserDiseCode", userDiseCode);
                startActivity(i);

                if(userDiseCode.equals(""))
                    Toast.makeText(getApplicationContext(), "Dise Code not available", Toast.LENGTH_LONG).show();
//                else
//                    new MarkAttendance().execute();
            }
        });
    }


//    private class MarkAttendance extends AsyncTask<String, Void, ArrayList<StudentInfo>> {
//
//        private ProgressDialog dialog = new ProgressDialog(MainActivity.this);
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            try {
//                if (dialog == null) {
//                    dialog = new ProgressDialog(MainActivity.this);
//
//                }
//                dialog.setMessage("Fetching results.\nPlease wait...");
//                dialog.show();
//            }
//            catch (Exception e) {
//                Toast.makeText(MainActivity.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        @Override
//        protected ArrayList<StudentInfo> doInBackground(String... strings) {
//            return WebServiceHelper.GetStudentList(userDiseCode);
//        }
//
//        @Override
//        protected void onPostExecute(ArrayList<StudentInfo> pvmArrayList) {
//            super.onPostExecute(pvmArrayList);
//
//            Log.d("Student list :" ,""+pvmArrayList.size());
//        }
//    }
}