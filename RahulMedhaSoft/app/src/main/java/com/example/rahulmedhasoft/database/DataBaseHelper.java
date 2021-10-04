package com.example.rahulmedhasoft.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.ArrayRes;

import com.example.rahulmedhasoft.entity.StudentInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "";

    private static String DB_NAME = "LOCDB.db";


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private SQLiteDatabase myDataBase;

    private final Context myContext;

    String TAG = "DataBaseHelper";

    /**
     * Constructor Takes and keeps a reference of the passed context in order to
     * access to the application assets and resources.
     *
     * @param context
     */
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 3);
        Log.e("DataBaseHelper", "1");
        if (Build.VERSION.SDK_INT >= 4.2) {
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
            // By calling this method. The empty database will be created into
            // the default system path of your application so we will be able to
            // overwrite that database with our database.
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

            checkDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.NO_LOCALIZED_COLLATORS
                            | SQLiteDatabase.OPEN_READWRITE);


        } catch (SQLiteException e) {

            // database does't exist yet.

        }

        if (checkDB != null) {

            checkDB.close();

        }

        return checkDB != null ? true : false;

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

        // Path to the just creat empty db
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

        myOutput.flush();
        myOutput.close();
        myOutput.close();
    }

    public void openDataBase() throws SQLException {
        // Open the database
        this.getReadableDatabase();
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    public long setStudentDetails(ArrayList<StudentInfo> result) {
        long c = -1;
        ArrayList<StudentInfo> info = result;
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("StudentDetails", null, null);
        ContentValues values = new ContentValues();

        if (info != null) {
            try {
                for (int i = 0; i < info.size(); i++) {
                    values.put("ResultStatusMesg", info.get(i).getResultStatusMesg());
                    values.put("a_Id", info.get(i).getA_Id());
                    values.put("BeneficieryId", info.get(i).getBeneficieryId());
                    values.put("DiseCode", info.get(i).getDiseCode());
                    values.put("ClassId", info.get(i).getClassId());
                    values.put("BeneficieryName", info.get(i).getBeneficieryName());
                    values.put("FHName", info.get(i).getFHName());
                    values.put("MName", info.get(i).getMName());
                    values.put("Gender", info.get(i).getGender());
                    values.put("DOB", info.get(i).getDOB());
                    values.put("BenAccountNo", info.get(i).getBenAccountNo());
                    values.put("IFSCCode", info.get(i).getIFSCCode());
                    values.put("eupi_BenNameasPerBank", info.get(i).getEupi_BenNameasPerBank());
                    values.put("maxscore", info.get(i).getMaxscore());

                    c = db.insert("StudentDetails", null, values);

                    if (c > 0) {
                        Log.e("Data", "Inserted");
                    } else {
                        Log.e("Data", "Not Inserted");
                    }
                }

                this.getWritableDatabase().close();
                db.close();

            } catch (Exception e) {
                e.printStackTrace();

                if (db != null) {
                    db.close();
                }
                return c;
            } finally {
                if (db != null) {
                    safeCloseDB(db);
                }
            }
        }
        return c;
    }

    public static void safeCloseDB(SQLiteDatabase db) {
        if (db != null) {
            try {
                db.close();
            } catch (SQLiteException e) {
                Log.e("log_tag", "Error safeCloseDB" );
            }
        }
    }

    // Get Student Details
    public ArrayList<StudentInfo> getStudentDetails() {
        ArrayList<StudentInfo> stdDataEntities = new ArrayList<StudentInfo>();
        Cursor cursor = null;
        SQLiteDatabase  sqLiteDatabase = this.getWritableDatabase();
//        String SQLQ = "SELECT ResultStatusMesg, a_Id, BeneficieryId, DiseCode, ClassId, BeneficieryName, FHName, MName, Gender, DOB, BenAccountNo, IFSCCode, eupi_BenNameasPerBank, maxscore FROM" + "StudentDetails";

        try {

            String SQLQ = "SELECT BeneficieryName, FHName, MName FROM StudentDetails";

            cursor = sqLiteDatabase.rawQuery(SQLQ, null);

            int x = cursor.getCount();

            while (cursor.moveToNext()) {
                StudentInfo student = new StudentInfo();
                student.setBeneficieryName((cursor.getString(cursor.getColumnIndex("BeneficieryName"))));
                student.setFHName(cursor.getString(cursor.getColumnIndex("FHName")));
                student.setMName(cursor.getString(cursor.getColumnIndex("MName")));
                /**
                 * add morew details
                 */
                stdDataEntities.add(student);
            }
            this.getReadableDatabase().close();
            cursor.close();
            sqLiteDatabase.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stdDataEntities;
    }
}
