package com.example.rahulmedhasoft;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    Button loginButton;
    EditText editTextDiseCode;
    EditText editTextMobileNumber;
    EditText editTextOtp;
    UserDetails userDetails;

    String userDiseCode;
    String userMobileNumber;
    String userOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.btn_login);
        editTextDiseCode = findViewById(R.id.editTextDiseCode);
        editTextMobileNumber = findViewById(R.id.editTextMobileNumber);
        editTextOtp = findViewById(R.id.editTextOtp);

        Toast.makeText(getApplicationContext(), "Login Page", Toast.LENGTH_SHORT).show();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);

                //abhinavkumar9315@gmail.com
//                http://localhost:58639/WebServiceAPI.asmx?op=SchoolLogin
            }
        });

    }


    public void Login() {

//        udisecode ="10280105518";// txtdisecode.getText().toString();
//        umobnum = "9507638140";  //txtmobnum.getText().toString();
//        userotp = "3376";  //txtotp.getText().toString();

        userDiseCode = editTextDiseCode.getText().toString();
        userMobileNumber = editTextMobileNumber.getText().toString();
        userOtp = editTextOtp.getText().toString();

        boolean cancelRegistration = false;
        String isValied = "yes";
        View focusView = null;

        if (TextUtils.isEmpty(userDiseCode)) {
            editTextDiseCode.setError("Enter Dise Code");
            focusView = editTextDiseCode;
            cancelRegistration = true;
        }
        else if (TextUtils.isEmpty(userMobileNumber)) {
            editTextMobileNumber.setError("Enter Dise Code");
            focusView = editTextMobileNumber;
            cancelRegistration = true;
        } else if (userOtp.length() != 4) {
            editTextOtp.setError("Enter Valid OTP");
            focusView = editTextOtp;
            cancelRegistration = true;
        }


        if (cancelRegistration) {
            // error in login
            focusView.requestFocus();
        } else {
            //userDetails = new UserDetails();
            userDetails.setDiseCode(userDiseCode);
            userDetails.setMobile(userOtp);
            // new RegistrationTask().execute(userDetails);
            new Getalldetails(userDiseCode,userMobileNumber,userOtp).execute();
        }
    }
}


//import androidx.appcompat.app.AppCompatActivity;
//
//public class login extends AppCompatActivity {
//
//    Button loginButton = findViewById(R.id.loginButton);
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(login.this, MainActivity.class);
//                intent.putExtra("value1", "admin");
//                intent.putExtra("value2", "admin@123");
//                startActivity(intent);
//            }
//        });
//
//    }
//}
