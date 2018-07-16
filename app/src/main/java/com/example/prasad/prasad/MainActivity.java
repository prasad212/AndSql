package com.example.prasad.prasad;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.example.prasad.prasad.DATA.Contract;
import com.example.prasad.prasad.DATA.OpenHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void openaddstudnt(View view)
    {
        Intent intent = new Intent(this,addstudent.class);
        startActivity(intent);
    }
    public void onclick(View v)
    {
        Intent intent = new Intent( this,ListLayout.class);
        startActivity(intent);

    }
   /* private void displayDatabaseInfo()
    {
        OpenHelper openHelper = new OpenHelper(this);
         SQLiteDatabase db =openHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM "+Contract.studentry.TABLE_NAME,null);
             try{

                 TextView textView = (TextView)findViewById(R.id.textView);
                 textView.setText("no of rows in database is"+cursor.getColumnCount());
             }   finally {
                 cursor.close();
             }

    }
    */
    public void upgradedata (View view)
    {
        OpenHelper mydb = new OpenHelper(this);
        SQLiteDatabase db = mydb.getReadableDatabase();
        mydb.onUpgrade(db,1,2);

    }
}

