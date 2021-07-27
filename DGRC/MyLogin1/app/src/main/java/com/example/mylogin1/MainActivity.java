package com.example.mylogin1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylogin1.database.DataBaseHelper;
import com.example.mylogin1.database.WebServiceHelper;

//import in.nic.bih.oprmcmonitoring.activity.LoginActivity;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    EditText et_login,et_password;
    Button btn_login;
    String username,password;
    private ProgressDialog dialog;
//    String version = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initialization();

        dialog = new ProgressDialog(MainActivity.this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SetValue();

                if (validateData()) {
                    Toast.makeText(MainActivity.this, "Your data is entered", Toast.LENGTH_SHORT).show();
                    new LoginTask().execute(); //calling asynctask to execute
                }
            }
        });

        // Get the app's shared preferences
        SharedPreferences app_preferences =
                PreferenceManager.getDefaultSharedPreferences(this);

        // Get the value for the run counter
        int counter = app_preferences.getInt("counter", 0);

        // Update the TextView
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("This app has been started " + counter + " times.");

        // Increment the counter
        SharedPreferences.Editor editor = app_preferences.edit();
        editor.putInt("counter", ++counter);
        editor.commit(); // Very important

    }

    private void Initialization()
    {
        et_login=findViewById(R.id.edit_text_username);
        et_password=findViewById(R.id.edit_text_pass);
        btn_login = findViewById(R.id.button_login);
    }

    private void SetValue()
    {
        username=et_login.getText().toString().trim();
        password=et_password.getText().toString().trim();
    }

    private boolean validateData() {
//        View focusView = null; //why?

        boolean validate = true;

        // what?
        // equalsIgnoreCase: compare 2 strings irrespective of the case (lower or upper) of the string

        if (username.equals("")) {
            Toast.makeText(getApplicationContext(), "Please fill User Name", Toast.LENGTH_LONG).show();
            validate = false;
        } else if (password.equals("")) {
            Toast.makeText(getApplicationContext(), "Please fill Password", Toast.LENGTH_LONG).show();
            validate = false;
        }

        //what? and why?
//        if(focusView != null && focusView.requestFocus()) {
//            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
//        }

        return validate;
    }

    // AsyncTask Class begins
    private class LoginTask extends AsyncTask<String, Void, UserLogin> {


        protected void onPreExecute() {


            dialog.show();
            dialog.setMessage("Authenticating...");
        }

        // further attention !!!
        // what?
        // UserLogin and Utiilties are different classes
        @Override
        protected UserLogin doInBackground(String... params) {

//            if (!Utiilties.isOnline(LoginActivity.this))
//            {
//                return OfflineLogin(username,password);
//            }
//
//            else{
                //Login is method in WebServiceHelper
                // fetching username, password (GET - POST) from web
                return WebServiceHelper.Login(username, password);
          //  }

        }

        @Override
        protected void onPostExecute(UserLogin result) {
            super.onPostExecute(result);

//            if (dialog.isShowing()) {
//                dialog.dismiss();
//            }
            long c = 0;
            if (result != null) {
                if (result.getAuthenticated()) {

                        Log.d("username",result.get_UserName());
                    if (result.get_Role().equalsIgnoreCase("JEADM")||result.get_Role().equalsIgnoreCase("AEADM")||result.get_Role().equalsIgnoreCase("EEADM")||result.get_Role().equalsIgnoreCase("SEADM")) {
                        dialog.dismiss();
                        String userid = result.get_UserID();
                        String userpss = result.get_Password();
                   /* String imei1=result.getImei();
                    String abc=imei;*/
                        GlobalVariables.LoggedUser = result;
                        GlobalVariables.LoggedUser.set_UserID(username);

                        GlobalVariables.LoggedUser.set_Password(password);
                        CommonPref.setUserDetails(getApplicationContext(), GlobalVariables.LoggedUser);

                        c = dataBaseHelper.insertUserDetail(result, username, password);
//                        if (c > 0) {
//                            new Division_List().execute();

//                        } else {
                        dialog.dismiss();
//                            Toast.makeText(getApplicationContext(), "Credentials not inserted", Toast.LENGTH_LONG).show();
//                        }

                    } else {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), " Invalid UserId And Password ", Toast.LENGTH_LONG).show();
                    }

                    Log.d("ResultValue", "" + result);
                    // insertinShared(result);
                }
                else {
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), " Invalid UserId And Password ", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), " Result:null", Toast.LENGTH_LONG).show();
            }
        }
    }
}