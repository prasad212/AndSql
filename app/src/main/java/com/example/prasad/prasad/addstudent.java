package com.example.prasad.prasad;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prasad.prasad.DATA.Contract;
import com.example.prasad.prasad.DATA.OpenHelper;
import com.example.prasad.prasad.DATA.StudentProvider;

public class addstudent extends AppCompatActivity {
    OpenHelper mydb;
    SQLiteDatabase db;
    EditText sname, sdob, scontact;
    Button addstudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);
        mydb = new OpenHelper(this);

        sname = findViewById(R.id.name);
        sdob = findViewById(R.id.dob);
        scontact = findViewById(R.id.mob);
        addstudent = findViewById(R.id.addstudent);
        //get text indisplayDatabaseInfo() string

    }

    public void adddata(View view) {

        String name = sname.getText().toString();
        String dob = sdob.getText().toString();
        String contact = scontact.getText().toString();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Contract.studentry.COLUMN_NAME, name);
        contentValues.put(Contract.studentry.COLUMN_DOB, dob);
        contentValues.put(Contract.studentry.COLUMN_CONTACT, contact);


        // This is a NEW pet, so insert a new pet into the provider,
        // returning the content URI for the new pet.
        Uri newUri = getContentResolver().insert(Contract.studentry.CONTENT_URI, contentValues);

        // Show a toast message depending on whether or not the insertion was successful.
        if (newUri == null) {
            // If the new content URI is null, then there was an error with insertion.
            Toast.makeText(this, "Faild",
                    Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast.
            Toast.makeText(this, "Passed",
                    Toast.LENGTH_SHORT).show();
        }
        //cursor
  /*  private void displayDatabaseInfo() {



        Cursor cursor = getContentResolver().query(Contract.studentry.CONTENT_URI,Contract.studentry.projection,null,null,null,null);
        TextView textView = (TextView) findViewById(R.id.norow);


        try {


            textView.setText("Student table contains " + cursor.getCount() + "\n");
            textView.append(Contract.studentry._ID + " - " + Contract.studentry.COLUMN_NAME);


            int idColumnIndex = cursor.getColumnIndex(Contract.studentry._ID);
            int nameColumnIndex = cursor.getColumnIndexOrThrow(Contract.studentry.COLUMN_NAME);


            while (cursor.moveToNext())
            {
                int currenId = cursor.getInt(idColumnIndex);
                String currenName = cursor.getString(nameColumnIndex);

                textView.append("\n" + currenId + " - " + currenName);

            }

        } finally {
            cursor.close();
        }
    }
*/
    }
}


