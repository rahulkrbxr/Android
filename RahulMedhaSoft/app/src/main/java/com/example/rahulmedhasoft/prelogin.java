package com.example.rahulmedhasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.Inet4Address;

public class prelogin extends AppCompatActivity {

    Button buttonSchoolDetails;
    Button buttonStudentDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prelogin);
        school_login sl = new school_login();

        buttonSchoolDetails = findViewById(R.id.buttonSchoolDetails);
        buttonStudentDetails = findViewById(R.id.buttonStudentDetails);

        buttonSchoolDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check if user credentials is saved or not
                // if saved bypass login for school or student details
                // else no
                if( !(sl.userDiseCode.isEmpty()) && !(sl.userMobileNumber.isEmpty()) && !(sl.userOtp.isEmpty()) ) {
                    Toast.makeText(getApplicationContext(), sl.userDiseCode+"\n"+sl.userMobileNumber, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(prelogin.this, MainActivity.class);
                    startActivity(intent);
                } /*else if( (!sl.userDiseCode.isEmpty()) && ((sl.userMobileNumber.isEmpty()) && (sl.userOtp.isEmpty())) ) {

                    Intent intent = new Intent(prelogin.this, student_login.class);
                    startActivity(intent);

                } */ else {
                    Intent intent = new Intent(prelogin.this, school_login.class);
                    startActivity(intent);
                }
            }
        });

        buttonStudentDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(prelogin.this, student_login.class);
                startActivity(intent);
            }
        });
    }
}