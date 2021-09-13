package com.example.rahulmedhasoft;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rahulmedhasoft.database.WebServiceHelper;
import com.example.rahulmedhasoft.entity.UserDetails;

public class login extends AppCompatActivity {

    Button loginButton;
    EditText editTextDiseCode;
    EditText editTextMobileNumber;
    EditText editTextOtp;
    UserDetails userDetails;

    private String userDiseCode="";
    private String userMobileNumber="";
    private String userOtp="";

    SharedPreferences sharedpreferences;
//    SharedPreferences sharedpreferences = getSharedPreferences("com.example.rahulmedhasoft", Context.MODE_PRIVATE);
//    public static final String MyPREFERENCES = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.btn_login);
        editTextDiseCode = findViewById(R.id.editTextDiseCode);
        editTextMobileNumber = findViewById(R.id.editTextMobileNumber);
        editTextOtp = findViewById(R.id.editTextOtp);


        Toast.makeText(getApplicationContext(), "login Page", Toast.LENGTH_SHORT).show();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
                //abhinavkumar9315@gmail.com
                //http://localhost:58639/WebServiceAPI.asmx?op=Schoollogin

            }
        });

    }


    public void login() {

        userDiseCode = editTextDiseCode.getText().toString().trim();
        userMobileNumber = editTextMobileNumber.getText().toString().trim();
        userOtp = editTextOtp.getText().toString().trim();

        boolean cancelRegistration = false;
        //  String isValied = "yes";
        View focusView = null;

        if (TextUtils.isEmpty(editTextDiseCode.getText().toString())) {
            editTextDiseCode.setError("Enter Dise Code");
            focusView = editTextDiseCode;
            cancelRegistration = true;
        } else if (TextUtils.isEmpty(editTextMobileNumber.getText().toString())) {
            editTextMobileNumber.setError("Enter Mobile No");
            focusView = editTextMobileNumber;
            cancelRegistration = true;
        } else if (editTextOtp.getText().length() < 4) {
            editTextOtp.setError("Enter Valid OTP");
            focusView = editTextOtp;
            cancelRegistration = true;
        }


        if (cancelRegistration) {
            // error in login
            focusView.requestFocus();
        } else {
            userDetails = new UserDetails();
            userDetails.setDiseCode(userDiseCode);
            userDetails.setMobileNo(userMobileNumber);
            userDetails.setOtp(userOtp);
            // new RegistrationTask().execute(userDetails);
            new Login().execute();
        }
    }

    private class Login extends AsyncTask<String, Void, String> {

        private ProgressDialog dialog = new ProgressDialog(login.this);


        protected void onPreExecute() {
            try {
                if (dialog == null) {
                    dialog = new ProgressDialog(login.this);

                }
                dialog.setMessage("Verifying your credential.\nPlease wait...");
                dialog.show();
            }
            catch (Exception e) {
//                Log.i("Error", String.valueOf(e));
                Toast.makeText(login.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            String res= WebServiceHelper.AuthenticatMethod(userDiseCode, userMobileNumber, userOtp);

             return res;
        }

        @Override
        protected void onPostExecute(String result) {

            if (result!=null)
            {
                // when input details is verified saved the details to
                // userDiseCode, userMobileNumber, userOtp
                sharedpreferences = getSharedPreferences("com.example.rahulmedhasoft", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserDiseCode", userDiseCode);
                editor.putString("UserMobileNumber", userMobileNumber);
                editor.putString("UserOtp", userOtp);
                editor.apply();

                // verified user credentials
                // saving details on string varible
                // for further bypassing login
                userDiseCode = sharedpreferences.getString("UserDiseCode", "");
                userMobileNumber = sharedpreferences.getString("UserMobileNumber", "");
                userOtp = sharedpreferences.getString("UserOtp", "");

//                userDiseCode = sharedpreferences.getString("UserDiseCode", "");
//                userMobileNumber = sharedpreferences.getString("UserMobileNumber", "");
//                userOtp = sharedpreferences.getString("UserOtp", "");

                Toast.makeText(login.this, result, Toast.LENGTH_SHORT).show();
                // condition to check if credential are correct
                if(result.equals("1-Login Successfully ")) {
                    Intent i = new Intent(login.this, MainActivity.class);
                    i.putExtra("UserDiseCode", userDiseCode);
                    i.putExtra("UserMobileNumber", userMobileNumber);
                    i.putExtra("UserOtp", userOtp);
                    startActivity(i);
                } else {
                    userDiseCode = "";
                    userMobileNumber = "";
                    userOtp = "";
                    Toast.makeText(login.this, "Authentication Failed\nWrong credentials", Toast.LENGTH_SHORT).show();
                }

            } else {
                // when input detail is wrong, empty the user info
                userDiseCode = "";
                userMobileNumber = "";
                userOtp = "";

                Toast.makeText(login.this, "Failed to get response from web service", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
