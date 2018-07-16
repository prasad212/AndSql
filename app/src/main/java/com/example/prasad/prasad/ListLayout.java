package com.example.prasad.prasad;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.prasad.prasad.DATA.Contract;
import com.example.prasad.prasad.DATA.OpenHelper;

import java.util.ArrayList;

public class ListLayout extends AppCompatActivity implements   LoaderManager.LoaderCallbacks<Cursor>  {

    private static final int STUDENT_LOADER=1;
ListView listView;
    StudentAdapter studentAdapter = new StudentAdapter(this,null);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);
         listView = (ListView)findViewById(R.id.text_list);
         listView.setAdapter(studentAdapter);

         getLoaderManager().initLoader(STUDENT_LOADER,null,this);



        }







    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {


        return new CursorLoader(this,Contract.studentry.CONTENT_URI,Contract.studentry.projection
        ,null
        ,null
        ,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
studentAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
studentAdapter.swapCursor(null);
    }
}
