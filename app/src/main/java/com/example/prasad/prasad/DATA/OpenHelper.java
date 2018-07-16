package com.example.prasad.prasad.DATA;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

import com.example.prasad.prasad.DATA.Contract.studentry;



public class OpenHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "student.db";

    public OpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.v("addstudent", "constructor is called ");
    }

    //column  name
    private studentry con;


    public static final String[] columns = {Contract.studentry._ID, Contract.studentry.COLUMN_NAME, Contract.studentry.COLUMN_DOB};

    private static final String quary = "CREATE TABLE " + Contract.studentry.TABLE_NAME + "(" +
            studentry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            studentry.COLUMN_NAME + "  NOT NULL ," +
            studentry.COLUMN_DOB + "  NOT NULL ," +
            studentry.COLUMN_CONTACT + "  NOT NULL );";


    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        db.execSQL(quary);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String quary = "DROP TABLE IF EXISTS "+ studentry.TABLE_NAME;
        sqLiteDatabase.execSQL(quary);
        Log.v("ON upgrade","IN ON upgrade");
        onCreate(sqLiteDatabase);
    }

    public boolean insertdata(String name, String dob, String contactno) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(studentry.COLUMN_NAME, name);
        contentValues.put(studentry.COLUMN_DOB, dob);
        contentValues.put(studentry.COLUMN_CONTACT, contactno);
        long result = db.insert(studentry.TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


}


