package com.example.mylogin1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mylogin1.UserLogin;

import org.ksoap2.serialization.SoapObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static String DB_PATH = "";
    private static String DB_NAME = "appDatabase.db";

    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DataBaseHelper(Context context) {

        super(context, DB_NAME, null, 1);
        if (android.os.Build.VERSION.SDK_INT >= 4.2) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.myContext = context;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own
     * database.
     */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if (dbExist) {
            // do nothing - database already exist


        } else {

            // By calling this method and empty database will be created into
            // the default system path
            // of your application so we are gonna be able to overwrite that
            // database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each
     * time you open the application.
     *
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            //this.getReadableDatabase();

            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.OPEN_READWRITE);


        } catch (SQLiteException e) {

            // database does't exist yet.

        }

        if (checkDB != null) {

            checkDB.close();

        }

        return checkDB != null;

    }

    public boolean databaseExist() {


        File dbFile = new File(DB_PATH + DB_NAME);

        return dbFile.exists();
    }

    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     */
    private void copyDataBase() throws IOException {

        // Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        this.getReadableDatabase().close();
        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();


    }

    public void openDataBase() throws SQLException {

        // Open the database
        this.getReadableDatabase();
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if (myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertUserDetail(UserLogin result, String userid, String pass) {
        long c = 0;
        try {

            SQLiteDatabase db = this.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put("UserRole", result.get_Role());
            values.put("UserId", userid.toLowerCase());
            values.put("User_Name", result.get_UserName());
            values.put("Password", pass.toLowerCase());
            values.put("Designation", result.get_Designation());
            values.put("Circle_Id", result.get_CircleID());
            values.put("Circle_nm", result.getCircleName());
            values.put("Wing_Id", result.get_WingID());
            values.put("Wing_nm", result.get_WingName());
            values.put("Pending_work", result.get_PendingWorks());
            values.put("Division_Id", result.get_DivisionID());
            values.put("Division_nm", result.get_DivisionName());

            String[] whereArgs = new String[]{userid};

            c = db.update("UserLogin", values, "UserId =?", whereArgs);

            if (!(c > 0)) {
                c = db.insert("UserLogin", null, values);

            }

            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;

    }

//    public long updatePassword(String userid, String pass) {
//        long c = 0;
//        try {
//
//            SQLiteDatabase db = this.getReadableDatabase();
//            ContentValues values = new ContentValues();
//            values.put("Password", pass);
//            //  values.put("UserId", userid.toLowerCase());
//
//
//            String[] whereArgs = new String[]{userid};
//
//            c = db.update("UserLogin", values, "UserId =?", whereArgs);
//
////            if (!(c > 0))
////            {
////                c = db.insert("UserLogin", null, values);
////
////            }
//
//            db.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return c;
//
//    }


    public UserLogin getUserDetails1(String userId, String pass) {

        UserLogin userInfo = null;
        String whereClouse = "User_Id=? and Password=?";


        try {

            SQLiteDatabase db = this.getReadableDatabase();

            String[] params = new String[]{userId, pass};
            Cursor cur = db.rawQuery("Select * FROM UserLogin WHERE UserId='" + userId.trim() + "' AND Password='" + pass.trim() + "'", null);
            int x = cur.getCount();

            while (cur.moveToNext()) {

                userInfo = new UserLogin();
//                userInfo.set_Userrole(cur.getString(cur.getColumnIndex("UserRole")));
                userInfo.set_UserID(cur.getString(cur.getColumnIndex("UserId")));
                userInfo.set_UserName(cur.getString(cur.getColumnIndex("User_Name")));
                userInfo.set_Password(cur.getString(cur.getColumnIndex("Password")));
                userInfo.set_Designation(cur.getString(cur.getColumnIndex("Designation")));
                userInfo.set_PendingWorks(cur.getString(cur.getColumnIndex("Pending_work")));
                userInfo.set_CircleID(cur.getString(cur.getColumnIndex("Circle_Id")));
                userInfo.setCircleName(cur.getString(cur.getColumnIndex("Circle_nm")));
                userInfo.set_WingID(cur.getString(cur.getColumnIndex("Wing_Id")));
                userInfo.set_WingName(cur.getString(cur.getColumnIndex("Wing_nm")));
                userInfo.set_DivisionID(cur.getString(cur.getColumnIndex("Division_Id")));
                userInfo.set_DivisionName(cur.getString(cur.getColumnIndex("Division_nm")));
            }

            cur.close();
            db.close();

        } catch (Exception e) {
            // TODO: handle exception
            userInfo = null;
        }
        return userInfo;
    }

}
