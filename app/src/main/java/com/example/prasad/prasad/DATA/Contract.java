package com.example.prasad.prasad.DATA;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public  final class Contract {
    public Contract()
    {}
public static final class studentry implements BaseColumns
{

   public final static String TABLE_NAME= "student";
    public static final String _ID = BaseColumns._ID;
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_CONTACT = "contactno";
    public static final String projection[] = {Contract.studentry._ID,Contract.studentry.COLUMN_NAME,Contract.studentry.COLUMN_DOB,Contract.studentry.COLUMN_CONTACT};


        public  static  final  String Content_Authority = "com.example.prasad.prasad";
        public static final Uri Base_content_uri =Uri.parse("content://"+Content_Authority);
        public static final String path ="student";
        public  static final Uri CONTENT_URI = Uri.withAppendedPath(Base_content_uri,path);


    /**
     * The MIME type of the {@link #CONTENT_URI} for a list of pets.
     */
    public static final String CONTENT_LIST_TYPE =
            ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + Content_Authority + "/" + path;

    /**
     * The MIME type of the {@link #CONTENT_URI} for a single pet.
     */
    public static final String CONTENT_ITEM_TYPE =
            ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + Content_Authority + "/" + path;
}
}