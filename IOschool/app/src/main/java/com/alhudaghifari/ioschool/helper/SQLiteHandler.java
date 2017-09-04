package com.alhudaghifari.ioschool.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Alhudaghifari on 9/1/2017.
 */

public class SQLiteHandler extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHandler.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ioschool";

    // Login table name
    private static final String TABLE_USER = "siswa";

    // Login Table Columns names
    private static final String KEY_NIS = "NIS";
    private static final String KEY_NAMALENGKAP = "Namalengkap";
    private static final String KEY_USERNAME = "Username";
    private static final String KEY_ANGKATAN = "Angkatan";
    private static final String KEY_IDSEKOLAH = "id_sekolah";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_NIS + " INTEGER PRIMARY KEY,"
                + KEY_NAMALENGKAP + " TEXT,"
                + KEY_USERNAME + " TEXT UNIQUE,"
                + KEY_ANGKATAN + " INTEGER, "
                + KEY_IDSEKOLAH + " INTEGER" + ")";
        db.execSQL(CREATE_LOGIN_TABLE);

        Log.d(TAG, "Database tables created");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        // Create tables again
        onCreate(db);
    }

    /**
     * Storing user details in database
     * */
    public void addUser(String nis, String namalengkap, String username, String angkatan, String id_sekolah) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NIS, nis);
        values.put(KEY_NAMALENGKAP, namalengkap); // Name
        values.put(KEY_USERNAME, username); // Email
        values.put(KEY_ANGKATAN, angkatan); // angkatan
        values.put(KEY_IDSEKOLAH, id_sekolah); // id sekolah

        // Inserting Row
        long id = db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection

        Log.d(TAG, "New user inserted into sqlite: " + id);
    }

    /**
     * Getting user data from database
     * */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("NIS", cursor.getString(0));
            user.put("Namalengkap", cursor.getString(1));
            user.put("Username", cursor.getString(2));
            user.put("Angkatan", cursor.getString(3));
            user.put("id_sekolah", cursor.getString(4));
        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());

        return user;
    }

    /**
     * Re crate database Delete all tables and create them again
     * */
    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE_USER, null, null);
        db.close();

        Log.d(TAG, "Deleted all user info from sqlite");
    }

}

