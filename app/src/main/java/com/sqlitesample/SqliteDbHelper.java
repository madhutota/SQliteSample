package com.sqlitesample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by madhu on 05-Nov-17.
 */

public class SqliteDbHelper extends SQLiteOpenHelper {


    private static final int DATA_BASE_VERSION = 1;

    private static final String DATA_BASE_NAME = "user_data.db";

    private static final String TABLE_NAME = "USER_DETAILS";
    private static final String KEY_USER_ID = "id";
    private static final String KEY_USER_FIRST_NAME = "FIRST_NAME";
    private static final String KEY_USER_LAST_NAME = "LAST_NAME";
    private static final String KEY_USER_EMAIL = "EMIL";
    private static final String KEY_USER_PASSWORD = "PASSWORD";
    private static final String KEY_USER_PHONE_NUMBER = "PHONE_NUMBER";

    public SqliteDbHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }


    @Override

    public void onCreate(SQLiteDatabase db) {


        String CREATE_DATA_BASE = "CREATE TABLE" + TABLE_NAME + "(" + KEY_USER_ID +
                "INTEGER PRIMARY KEY ," + KEY_USER_FIRST_NAME + "TEXT ," +
                KEY_USER_LAST_NAME + "TEXT ," + KEY_USER_PHONE_NUMBER + "TEXT ," + KEY_USER_EMAIL + "TEXT" + ")";
        db.execSQL(CREATE_DATA_BASE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);

    }

    void addUserData(UserModel userModel) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USER_FIRST_NAME, userModel.getUser_first_name());
        contentValues.put(KEY_USER_LAST_NAME, userModel.getUser_last_name());
        contentValues.put(KEY_USER_EMAIL, userModel.getUser_email());
        contentValues.put(KEY_USER_PASSWORD, userModel.getUser_pass());
        contentValues.put(KEY_USER_PHONE_NUMBER, userModel.getUser_phone_number());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();

    }

    public UserModel getUserModel(int userId) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();


        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{KEY_USER_ID, KEY_USER_FIRST_NAME, KEY_USER_LAST_NAME, KEY_USER_PHONE_NUMBER,
                KEY_USER_PASSWORD, KEY_USER_EMAIL}, KEY_USER_ID + "=?", new String[]{String.valueOf(userId)}, null, null, null, null);

        UserModel userModel = new UserModel(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5));


        return userModel;


    }
}
