package com.example.prasad.prasad.DATA;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class StudentProvider extends ContentProvider {
    public static final int student = 100;
    public static final int student_id = 101;

    public static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {


        sUriMatcher.addURI(Contract.studentry.Content_Authority, Contract.studentry.path, student);
        sUriMatcher.addURI(Contract.studentry.Content_Authority, Contract.studentry.path + "#", student_id);

    }

    private OpenHelper mdbhelper;
    @Override
    public boolean onCreate() {
   mdbhelper = new OpenHelper(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder)
    {

        SQLiteDatabase database = mdbhelper.getReadableDatabase();

        Cursor cursor;

        int urimatchint = sUriMatcher.match(uri);
        switch (urimatchint) {
            case student:

                cursor = database.query(Contract.studentry.TABLE_NAME, projection, null, null, null, null, null, null);

                break;
            case student_id:

              selection = Contract.studentry._ID + "=?";
                selectionArgs = new String[]{
                        String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(Contract.studentry.TABLE_NAME, projection, selection, selectionArgs,
                        null, null, sortOrder);
                break;

            default:
                throw new IllegalArgumentException("IllegL ARGUMENT");
        }

        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }



    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case student:
                return insertstudent(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }

    }

    private Uri insertstudent(Uri uri, ContentValues contentValues) {
        SQLiteDatabase database = mdbhelper.getWritableDatabase();
        Log.v("insert data","in the insertdata in studentprovider");
        //
        long id = database.insert(Contract.studentry.TABLE_NAME, null, contentValues);
        if (id == -1) {
            Log.e("LOg tag", "ERROR WHILE INSERTING" + uri);
            return  null;
        }
       getContext().getContentResolver().notifyChange(uri,null);
        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        SQLiteDatabase database = mdbhelper.getWritableDatabase();
            
        return 0;
    }


    private int updateStudent(Uri uri, ContentValues contentValues) {
        return 0;
    }
}
