package com.sqlitesample.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sqlitesample.UserModel;

/**
 * Created by madhu on 17-Nov-17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATA_BASE_NAME = "userdata";

    private static final int DATA_BASE_VERSION = 1;

    private static final String TABLE_NAME = "user";
    private static final String UID = "user_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "emil";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String PASSWORD = "password";
    // private static final String REENTERPASSWORD = "re_enter_password";


   /* private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";*/


    private static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + UID + " INTERGER PRIMARY KEY AUTOINCREMENT," + FIRST_NAME + " TEXT," + LAST_NAME + " TEXT," + EMAIL + " TEXT," +
            PHONE_NUMBER + " TEXT," + PASSWORD + " TEXT" + ")";
    private static final String DROP_TABLE = "DROP TABLE IF EXIST" + TABLE_NAME;


    public DataBaseHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_USER_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addUser(UserModel userModel) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, userModel.getUser_first_name());
        contentValues.put(LAST_NAME, userModel.getUser_last_name());
        contentValues.put(EMAIL, userModel.getUser_email());
        contentValues.put(PHONE_NUMBER, userModel.getUser_phone_number());
        contentValues.put(PASSWORD, userModel.getUser_pass());
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();


    }

    public boolean checkUser(String email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String[] columns = {UID};
        String selection = EMAIL + "=?";
        String[] args = {email};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,
                columns,
                selection,
                args,
                null, null, null);

        int curserCount = cursor.getCount();

        cursor.close();
        sqLiteDatabase.close();

        return curserCount > 0;
    }

    public boolean checkUserEmailAndPassword(String email, String pass) {

        String[] columns = {
                UID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = EMAIL + " = ?" + " AND " + PASSWORD + " =?";
        String[] selectionArgs = {email, pass};

        Cursor cursor = db.query(TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int curserCount = cursor.getCount();
        cursor.close();
        db.close();

        return curserCount > 0;
    }

  /*  public ArrayList<UserModel>getAllusersList(){

    }*/
}
