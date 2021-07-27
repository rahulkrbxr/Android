package com.example.mylogin1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class CommonPref {

    static Context context;

    CommonPref() {

    }

    CommonPref(Context context) {
        CommonPref.context = context;
    }



    public static void setUserDetails(Context context, UserLogin userInfo) {

        String key = "_USER_DETAILS";

        SharedPreferences prefs = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("UserId", userInfo.get_UserID());
        editor.putString("UserName", userInfo.get_UserName());
        editor.putString("UserPassword", userInfo.get_Password());
        editor.putString("Role", userInfo.get_Role());

        editor.putString("CircleId", userInfo.get_CircleID());
        editor.putString("CircleName", userInfo.getCircleName());
        editor.putString("WingId", userInfo.get_WingID());
        editor.putString("WingName", userInfo.get_WingName());
        editor.putString("DivisionId", userInfo.get_DivisionID());
        editor.putString("DivisionName", userInfo.get_DivisionName());
        editor.putString("Design", userInfo.get_Designation());
        //editor.putString("", userInfo.get_PackageId());

        editor.commit();

    }

    public static UserLogin getUserDetails(Context context) {

        String key = "_USER_DETAILS";
        UserLogin userInfo = new UserLogin();
        SharedPreferences prefs = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);

        userInfo.set_UserID(prefs.getString("UserId", ""));
        userInfo.set_UserName(prefs.getString("UserName", ""));
        userInfo.set_Password(prefs.getString("UserPassword", ""));
        userInfo.set_Role(prefs.getString("Role", ""));
        userInfo.set_CircleID(prefs.getString("CircleId", ""));
        userInfo.setCircleName(prefs.getString("CircleName", ""));

        userInfo.set_DivisionID(prefs.getString("DivisionId", ""));
        userInfo.set_DivisionName(prefs.getString("DivisionName", ""));
        userInfo.set_WingID(prefs.getString("WingId", ""));
        userInfo.set_PackageId("");
        userInfo.set_WingName(prefs.getString("WingName", ""));
        userInfo.set_Designation(prefs.getString("Desig", ""));

        return userInfo;
    }



    public static void setCheckUpdate(Context context, long dateTime) {

        String key = "_CheckUpdate";

        SharedPreferences prefs = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();


        dateTime=dateTime+1*3600000;
        editor.putLong("LastVisitedDate", dateTime);

        editor.commit();

    }

    public static int getCheckUpdate(Context context) {

        String key = "_CheckUpdate";

        SharedPreferences prefs = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);

        long a = prefs.getLong("LastVisitedDate", 0);


        if(System.currentTimeMillis()>a)
            return 1;
        else
            return 0;
    }

    public static void setAwcId(Activity activity, String awcid){
        String key = "_Awcid";
        SharedPreferences prefs = activity.getSharedPreferences(key,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("code2", awcid);
        editor.commit();
    }
}
