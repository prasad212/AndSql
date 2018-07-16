package com.example.prasad.prasad;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.prasad.prasad.DATA.Contract;
import com.example.prasad.prasad.DATA.OpenHelper;

public class StudentAdapter extends CursorAdapter {
   public StudentAdapter(Context context, Cursor c)
   {
        super(context,c,0);

   }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        return LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView list1 = (TextView)view.findViewById(R.id.text_view_list1);
        TextView list2 = (TextView)view.findViewById(R.id.text_view_list2);
        TextView list3 = (TextView)view.findViewById(R.id.text_view_list3);
        int coulmn1 = cursor.getColumnIndex(Contract.studentry.COLUMN_NAME);
        int column2 = cursor.getColumnIndex(Contract.studentry.COLUMN_DOB);
        int column3 = cursor.getColumnIndex(Contract.studentry.COLUMN_CONTACT);


        String body1 =cursor.getString(coulmn1);
        String body2 = cursor.getString(column2);
        String body3 = cursor.getString(column3);
        list1.setText(body1);
        list2.setText(body2);
        list3.setText(body3);


    }
}
