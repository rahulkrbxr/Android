package com.example.rahulmedhasoft;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.rahulmedhasoft.database.WebServiceHelper;
import com.example.rahulmedhasoft.entity.GetStudentDetails;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.rahulmedhasoft.databinding.ActivityStudentLoginBinding;

public class student_login extends AppCompatActivity {

    Button btn_student_login;
    EditText editTextDiseCode;
    String student_userDiseCode;
    private GetStudentDetails getStudentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        btn_student_login = findViewById(R.id.btn_student_login);
        editTextDiseCode = findViewById(R.id.editTextDiseCode);
        // code down below will be similar
        // to school_login

        // this fn is just for testing pursose
        // remove before actual implementation of student_login
        btn_student_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(student_login.this, student_details.class);
                startActivity(intent);
            }
        });

        public void login() {
            student_userDiseCode = editTextDiseCode.getText().toString().trim();

            View view = null;
            Boolean cancelRegistration = false;

            if(TextUtils.isEmpty(student_userDiseCode)) {
                editTextDiseCode.setError("Enter Dise Code");
                view = editTextDiseCode;
                cancelRegistration = true;
            }

            if(cancelRegistration) {
                view.requestFocus();
                getStudentDetails = new GetStudentDetails();
                getStudentDetails.setDiseCode(student_userDiseCode);
                new StudnetLogin().execute();
            }
        }


        private class StudentLogin extends AsyncTask<String, Void, String> {

            private ProgressDialog dialog = new ProgressDialog(school_login.this);


            protected void onPreExecute() {
                try {
                    if(dialog!=null) {
                        dialog.setMessage("Verifying your credential.\nPlease wait...");

                        dialog.show();
                    }
                    else
                    {
                        dialog = new ProgressDialog(school_login.this);
                        dialog.setMessage("Verifying your credential.\nPlease wait...");

                        dialog.show();
                    }
                }
                catch (Exception e)
                {
//                Log.i("Error", String.valueOf(e));
                    Toast.makeText(school_login.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
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
//                    sharedpreferences = getSharedPreferences("userLoginDetails", 0);
//                    SharedPreferences.Editor editor = sharedpreferences.edit();
//
//                    editor.putString("UserDiseCode", userDiseCode);
//                    editor.putString("UserMobileNumber", userMobileNumber);
//                    editor.putString("UserOtp", userOtp);
//                    editor.commit();

                    // verified user credentials
                    // saving details on string varible
                    // for further bypassing login
//                    userDiseCode = sharedpreferences.getString("UserDiseCode", "");
//                    userMobileNumber = sharedpreferences.getString("UserMobileNumber", "");
//                    userOtp = sharedpreferences.getString("UserOtp", "");

//                userDiseCode = sharedpreferences.getString("UserDiseCode", "");
//                userMobileNumber = sharedpreferences.getString("UserMobileNumber", "");
//                userOtp = sharedpreferences.getString("UserOtp", "");

                    Toast.makeText(student_login.this, result, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), student_details.class);
                    startActivity(i);
                } else {
                    // when input detail is wrong, empty the user info
//                    userDiseCode = "";
//                    userMobileNumber = "";
//                    userOtp = "";

                    Toast.makeText(student_login.this, "Failed to get response from web service", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}