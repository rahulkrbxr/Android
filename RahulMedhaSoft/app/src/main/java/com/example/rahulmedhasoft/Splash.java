package com.example.rahulmedhasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i; // = new Intent(Splash.this, school_login.class);
                // Intent i = new Intent(Splash .this, PREHomeActivity.class);
//                startActivity(i);

                SharedPreferences sharedPreferences = getSharedPreferences("userLoginDetails", 0);
                String userDiseCode = sharedPreferences.getString("UserDiseCode", "");
                String userMobileNumber = sharedPreferences.getString("UserMobileNumber", "");
                String userOtp = sharedPreferences.getString("UserOtp", "");

                if(userDiseCode.isEmpty() || userMobileNumber.isEmpty() || userOtp.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Empty Shared Preferances", Toast.LENGTH_SHORT).show();
                    i = new Intent(Splash.this, prelogin.class);
                } else {
                    Toast.makeText(Splash.this, "Dise: " + userDiseCode+"\n"+
                            "Mobile: "+userMobileNumber+"\n"+
                            "OTP: "+userOtp, Toast.LENGTH_LONG).show();
                    i = new Intent(Splash.this, MainActivity.class);
                }
                startActivity(i);

//
//                if(userDiseCode.isEmpty() || userMobileNumber.isEmpty() || userOtp.isEmpty()) {
//                    Intent i = new Intent(Splash.this, school_login.class);
//                    startActivity(i);
//                } else {
//                    Intent i = new Intent(Splash.this, MainActivity.class);
//                    startActivity(i);
//                }

                // close this activity
                finish();
            }
        }, 1000);

    }
}

//    public void Login() {
//
////        udisecode ="10280105518";// txtdisecode.getText().toString();
////        umobnum = "9507638140";  //txtmobnum.getText().toString();
////        userotp = "3376";  //txtotp.getText().toString();
//
//        udisecode =txtdisecode.getText().toString();
//        umobnum = txtmobnum.getText().toString();
//        userotp = txtotp.getText().toString();
//
//        boolean cancelRegistration = false;
//        String isValied = "yes";
//        View focusView = null;
//
//        if (TextUtils.isEmpty(udisecode)) {
//            txtdisecode.setError("Enter Dise Code");
//            focusView = txtdisecode;
//            cancelRegistration = true;
//        }
//        else if (TextUtils.isEmpty(umobnum)) {
//            txtmobnum.setError("Enter Dise Code");
//            focusView = txtmobnum;
//            cancelRegistration = true;
//        } else if (userotp.length() != 4) {
//            txtotp.setError("Enter Valid OTP");
//            focusView = txtotp;
//            cancelRegistration = true;
//        }
//
//
//        if (cancelRegistration) {
//            // error in school_login
//            focusView.requestFocus();
//        } else {
//            //userDetails = new UserDetails();
//            userDetails.setDiseCode(udisecode);
//            userDetails.setMobile(userotp);
//            // new RegistrationTask().execute(userDetails);
//            new Getalldetails(udisecode,umobnum,userotp).execute();
//
//        }
//    }