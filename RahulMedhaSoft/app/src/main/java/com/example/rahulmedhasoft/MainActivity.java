package com.example.rahulmedhasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rahulmedhasoft.database.DataBaseHelper;
import com.example.rahulmedhasoft.database.WebServiceHelper;
import com.example.rahulmedhasoft.entity.StudentInfo;
import com.example.rahulmedhasoft.entity.UserDetails;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    LinearLayout lin_logout;
    LinearLayout lin_home;
    LinearLayout lin_studentdetails;
    TextView diseCode;
    TextView mobileNo;
    TextView otp;
    UserDetails userDetails;
    DataBaseHelper localDB;
    SQLiteDatabase db;
    DataBaseHelper databaseHelper;
    DataBaseHelper dataBaseHelper;
    public static ProgressDialog progressDialog;
    DataBaseHelper placeData;
    private String userDiseCode="";
    private String userMobileNumber="";
    private String userOtp="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeData=new DataBaseHelper(MainActivity.this);
        try {
            placeData.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            placeData.openDataBase();

        } catch (SQLException sqle) {

            throw sqle;


        }

//         success in retrieving data from login.java
//        Intent intent = getIntent();
//        userDiseCode = intent.getStringExtra("UserDiseCode");
//        userMobileNumber = intent.getStringExtra("UserMobileNumber");
//        userOtp = intent.getStringExtra("UserOtp");
//        finish();
//        Toast.makeText(getApplicationContext(), userDiseCode + "\n" + userMobileNumber + "\n" + userOtp, Toast.LENGTH_SHORT).show();

//        UserDetails ud = new UserDetails();
//        Toast.makeText(getApplicationContext(), ud.getDiseCode()+'\n'+ud.getMobileNo(), Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPreferences = getSharedPreferences("userLoginDetails", 0);

        userDiseCode = sharedPreferences.getString("UserDiseCode", "");
        diseCode = findViewById(R.id.user_dise);
        diseCode.setText("Dise Code: " + userDiseCode);

        userMobileNumber = sharedPreferences.getString("UserMobileNumber", "");
        mobileNo = findViewById(R.id.total_students_mid_day_meal);
        mobileNo.setText("Mobile No: " + userMobileNumber);

        userOtp = sharedPreferences.getString("UserOtp", "");
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
        lin_studentdetails = findViewById(R.id.lin_studentdetails);
        lin_studentdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, StudentDetails.class);
//                i.putExtra("UserDiseCode", userDiseCode);
//                startActivity(i);

//                if(userDiseCode.equals(""))
//                    Toast.makeText(getApplicationContext(), "Dise Code not available", Toast.LENGTH_LONG).show();
//                else
                    new StudentList().execute();
            }
        });
    }


    private class StudentList extends AsyncTask<String, Void, ArrayList<StudentInfo>> {

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
            // shared preference not working
            // So, used UserDetails class getDiseCod() method to get dise code
           // return WebServiceHelper.GetStudentList(userDiseCode);
            return WebServiceHelper.GetStudentList("10130507504");
        }

        @Override
        protected void onPostExecute(ArrayList<StudentInfo> result) {
            super.onPostExecute(result);

//            Intent intent = new Intent(MainActivity.this, StudentDetails.class);
//            startActivity(intent);
            if (result != null) {
                if (result.size() > 0) {

                    Log.d("result.size", "" + result.size());
                    final String totalres = "" + result.size();
                    Toast.makeText(getApplicationContext(), totalres, Toast.LENGTH_SHORT).show();
                    DataBaseHelper helper = new DataBaseHelper(getApplicationContext());

                    long i = helper.setStudentDetails(result);

                    if (i > 0) {
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                        ab.setCancelable(false);
                        ab.setIcon(R.drawable.download);

                        ab.setTitle("DOWNLOAD SUCCESS");
                        ab.setMessage(result.size() + " Student Details Downloaded Successfully.");
                        Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setCanceledOnTouchOutside(false);
                        ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whichButton) {
//                                    txtTStd.setText(totalres);
//                                    txtTotalStudents.setText("Total Student : " + totalres);

//                                resetValueS();
                                dialog.dismiss();

                            }
                        });

                        ab.show();


                    } else {
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                        ab.setCancelable(false);
                        ab.setIcon(R.drawable.download);

                        ab.setTitle("DOWNLOAD FAIL");
                        ab.setMessage(" No Student Details Downloaded for DISE CODE: " + diseCode);
                        Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setCanceledOnTouchOutside(false);
                        ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whichButton) {

                                dialog.cancel();

                            }
                        });

                        ab.show();


                    }

                } else {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                    ab.setCancelable(false);
                    ab.setIcon(R.drawable.download);

                    ab.setTitle("DOWNLOAD FAIL");
                    ab.setMessage(" No Student Details Downloaded for DISE CODE: " + diseCode);
                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setCanceledOnTouchOutside(false);
                    ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int whichButton) {
                            dialog.dismiss();
                        }
                    });
                    ab.show();
                }
            } else {
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                Toast.makeText(getApplicationContext(), "Response NULL.", Toast.LENGTH_SHORT).show();
            }
        }
    }

//    public void resetValueS() {
//        DataBaseHelper helper = new DataBaseHelper(getApplicationContext());
//        countstd = helper.getStudentCountForUploading();
//        countattstd = helper.getStudentCountForAttendanceUploading();
//        countnew = helper.getStudentCountNew();
//        countMatched = helper.getStudentCountForMatchedByBank();
//        countNotMatchedBank = helper.getStudentCountForNotMatchedByBank();
//        countRejected = helper.getRejectedStudentCount();
//        countPFMS = helper.getStudentCountPFMSPending();
////        txtCount3.setText(String.valueOf(countattstd));
////        txtCount4.setText(String.valueOf(countattstd));
//        tv_newCount.setText(String.valueOf(countnew));
//        tv_Count2.setText(String.valueOf(countMatched));
//        tv_Count3.setText(String.valueOf(countPFMS));
//        tv_Count4.setText(String.valueOf(countNotMatchedBank));
//        tv_Count5.setText(String.valueOf(countRejected));
//
//        //long totalstd=helper.getTOTALStudentCount(_diseCode);
//        long totalstd = helper.getTOTALStudentCount();
//        long totalstdMDM = helper.getTOTALStudentCountMDM();
//
//        total_stud.setText("Total Student : " + totalstd);
//        total_stud_mid_day_meal.setText("Total Student(MID Day Meal) : " + totalstdMDM);
//
//        // txtTStd.setText(""+totalstd);
//    }
}