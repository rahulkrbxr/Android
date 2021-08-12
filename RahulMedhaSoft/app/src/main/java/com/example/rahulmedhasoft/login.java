package com.example.rahulmedhasoft;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

    String userDiseCode="";
    String userMobileNumber="";
    String userOtp="";

    SharedPreferences sharedpreferences;
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
//
//        userDiseCode ="10130507504";
//        userMobileNumber = "7004978930";
//        userOtp = "85013";

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
                if(dialog!=null) {
                    dialog.setMessage("Verifying your credential.\nPlease wait...");

                    dialog.show();
                }
                else
                {
                    dialog = new ProgressDialog(login.this);
                    dialog.setMessage("Verifying your credential.\nPlease wait...");

                    dialog.show();
                }
            }
            catch (Exception e)
            {
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
                sharedpreferences = getSharedPreferences("userLoginDetails", 0);
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("UserDiseCode", userDiseCode);
                editor.putString("UserMobileNumber", userMobileNumber);
                editor.putString("UserOtp", userOtp);
                editor.commit();

//                userDiseCode = sharedpreferences.getString("UserDiseCode", "");
//                userMobileNumber = sharedpreferences.getString("UserMobileNumber", "");
//                userOtp = sharedpreferences.getString("UserOtp", "");

                Toast.makeText(login.this, result, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(login.this, "Failed to get response from web service", Toast.LENGTH_SHORT).show();
            }
        }


//        @Override
//        protected void onPostExecute(Get_usersalldetails result) {
//            super.onPostExecute(result);
//
//            if (dialog.isShowing()) {
//                dialog.dismiss();
//            }
//            long c =0;
//            if (result != null) {
//                if (result.get_IsActive().equalsIgnoreCase("Y")) {
//                    try {
//                        DataBaseHelper placeData = new DataBaseHelper(login.this);
//                        c = placeData.insertAllUserDetails(result);
//                        if (c > 0) {
//                            // new   DwnldProvisionalMarks().execute();
//                            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("DISECODE", _dcode).commit();
//                            PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString("OTP", _otp).commit();
//                            Intent intent=new Intent(login.this, Main2Activity.class);
//                            //Intent intent=new Intent(login.this, HomeActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//                else {
//                    AlertDialog.Builder ab = new AlertDialog.Builder(login.this);
//                    ab.setTitle("INVALID");
//                    ab.setMessage("User is not active");
//                    ab.setPositiveButton("OK",
//                            new Dialoginterface.OnClickListener() {
//                                @Override
//                                public void onClick(Dialoginterface dialog, int whichButton) {
//                                    dialog.dismiss();
//                                }
//                            });
//
//                    ab.show();
//                }
//
//            }
//            else{
//                Toast.makeText(getApplicationContext(),"Response null",Toast.LENGTH_LONG).show();
//            }
//        }
    }
}
