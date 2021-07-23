//package in.nic.bih.oprmcmonitoring.activity;
////package com.example.mylogin1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.net.ConnectivityManager;
//import android.os.AsyncTask;
//import android.preference.PreferenceManager;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.mylogin1.MainActivity;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
////import in.nic.bih.oprmcmonitoring.R;
////import in.nic.bih.oprmcmonitoring.database.DataBaseHelper;
////import in.nic.bih.oprmcmonitoring.database.WebServiceHelper;
////import in.nic.bih.oprmcmonitoring.entity.CompliancesListEntity;
////import in.nic.bih.oprmcmonitoring.entity.DivisionList;
////import in.nic.bih.oprmcmonitoring.entity.SubComponentsEntity;
////import in.nic.bih.oprmcmonitoring.entity.UserLogin;
////import in.nic.bih.oprmcmonitoring.utilities.CommonPref;
////import in.nic.bih.oprmcmonitoring.utilities.GlobalVariables;
////import in.nic.bih.oprmcmonitoring.utilities.Utiilties;
//
//
//public class LoginActivity extends MainActivity {
//
////    DataBaseHelper dataBaseHelper;
//    EditText et_login,et_password;
//    Button btn_ligin;
//    String username,password;
//    private ProgressDialog dialog;
////    String version = "0";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Initialization();
//
//        dialog = new ProgressDialog(LoginActivity.this);
//
//        btn_ligin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SetValue();
//
//                if (validateData()) {
//                    new LoginTask().execute(); //calling asynctask to execute
//                }
//            }
//        });
//
////        try {
////
////            version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
////            TextView tv = (TextView) findViewById(R.id.txtVersion);
////            tv.setText("App_version-" + version);
////
////        } catch (PackageManager.NameNotFoundException e) {
////        }
//
//    }
//    private void Initialization()
//    {
//        et_login=findViewById(R.id.edit_text_username);
//        et_password=findViewById(R.id.edit_text_pass);
//        btn_ligin = findViewById(R.id.button_login);
//
//    }
//    private void SetValue()
//    {
//        username=et_login.getText().toString().trim();
//        password=et_password.getText().toString().trim();
//    }
//
//    private boolean validateData() {
//        View focusView = null; //why?
//        boolean validate = true;
//
//
//        // what?
//        if (username.equalsIgnoreCase("")) {
//            Toast.makeText(getApplicationContext(), "Please fill User Name", Toast.LENGTH_LONG).show();
//            validate = false;
//        } else if (password.equals("")) {
//            Toast.makeText(getApplicationContext(), "Please fill Password", Toast.LENGTH_LONG).show();
//            validate = false;
//        }
//        //what? and why?
//        if(focusView != null && focusView.requestFocus()) {
//            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
//        }
//        return validate;
//    }
//
////    private boolean isNetworkConnected() {
////        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
////
////        return cm.getActiveNetworkInfo() != null;
////
////    }
//
////    private class LoginTask extends AsyncTask<String, Void, UserLogin> {
////
////
////        protected void onPreExecute() {
////
////
////            dialog.show();
////            dialog.setMessage("Authenticating...");
////        }
////
////        // further attention !!!
////        // what?
////        // UserLogin and Utiilties are different classes
////        @Override
////        protected UserLogin doInBackground(String... params) {
////
////
////            if (!Utiilties.isOnline(LoginActivity.this))
////            {
////                return OfflineLogin(username,password);
////            }
////
////            else{
////                //Login is method in WebServiceHelper
////                // fetching username, password (GET - POST) from web
////                return WebServiceHelper.Login(username, password);
////            }
////
////        }
////
////        @Override
////        protected void onPostExecute(UserLogin result) {
////            super.onPostExecute(result);
////
//////            if (dialog.isShowing()) {
//////                dialog.dismiss();
//////            }
////            long c = 0;
////            if (result != null) {
////                if (result.getAuthenticated()) {
////                    if (result.get_Role().equalsIgnoreCase("JEADM")||result.get_Role().equalsIgnoreCase("AEADM")||result.get_Role().equalsIgnoreCase("EEADM")||result.get_Role().equalsIgnoreCase("SEADM")) {
////                        dialog.dismiss();
////                        String userid = result.get_UserID();
////                        String userpss = result.get_Password();
////                   /* String imei1=result.getImei();
////                    String abc=imei;*/
////                        GlobalVariables.LoggedUser = result;
////                        GlobalVariables.LoggedUser.set_UserID(username);
////
////                        GlobalVariables.LoggedUser.set_Password(password);
////                        CommonPref.setUserDetails(getApplicationContext(), GlobalVariables.LoggedUser);
////
////                        c = dataBaseHelper.insertUserDetail(result, username, password);
////                        if (c > 0) {
////                            new Division_List().execute();
////
////                        } else {
////                            dialog.dismiss();
////                            Toast.makeText(getApplicationContext(), "Credentials not inserted", Toast.LENGTH_LONG).show();
////                        }
////
////
////                    } else {
////                        dialog.dismiss();
////                        Toast.makeText(getApplicationContext(), " Invalid UserId And Password ", Toast.LENGTH_LONG).show();
////                    }
////
////                    Log.d("ResultValue", "" + result);
////                    // insertinShared(result);
////                }
////                else {
////                    dialog.dismiss();
////                    Toast.makeText(getApplicationContext(), " Invalid UserId And Password ", Toast.LENGTH_LONG).show();
////                }
////            } else {
////                Toast.makeText(getApplicationContext(), " Result:null", Toast.LENGTH_LONG).show();
////            }
////        }
////    }
//
//}
