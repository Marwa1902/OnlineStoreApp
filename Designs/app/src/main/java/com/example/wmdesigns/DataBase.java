package com.example.wmdesigns;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;
    private static DataBase instance;
    //the first time it was created, the verion is 1
    //because when we want o updrage the schema then ww will give it a version 2

    //Table and Columns names
    public static final String TABLE_USERS = "user";
    public static final String COLUMN_ID = "user_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "pass";

    //table queri
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USERNAME + " TEXT NOT NULL, " +
                    COLUMN_PASSWORD + " TEXT NOT NULL)";


    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        //creating the table here for the sql
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // handling database upgrades
        //if i want to upgrade my schema
        //oncreate is dbl
    }

    /*public SQLiteDatabase getReadableDatabase() {
        // Implement the logic to get a readable database
        return super.getReadableDatabase();
    }

    public static synchronized void init(Context context) {
        if (instance == null) {
            instance = new DataBase(context.getApplicationContext());
        }
    }

     */

}
