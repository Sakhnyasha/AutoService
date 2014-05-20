package com.autoservice.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by artem on 18.05.14.
 */
public class AutoInfo extends Activity {

    static final Uri CONTENT_URI_BOOKING = Uri.parse("content://com.autoservice.app.BookingDBOpenHelper/book");
    static final Uri CONTENT_URI_AUTO = Uri.parse("content://com.autoservice.app.AutoDBOpenHelper/auto");

    ArrayList<Booking> bookingArrayList = new ArrayList<Booking>();

    public String textCar;
    ContentResolver mContent;
    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);

        textCar = MainMenu.myAuto.manufacturer +" "+ MainMenu.myAuto.model+" "+Double.toString(MainMenu.myAuto.engineCapacity)+" ";
        textCar = textCar + Integer.toString(MainMenu.myAuto.maxSpeed)+" "+MainMenu.myAuto.color+" "+Integer.toString(MainMenu.myAuto.mileage);

        ((TextView) findViewById(R.id.car_info)).setText(textCar);

        mContent = getContentResolver();
        String selection = "auto_id = ?";
        String [] selectionArgs = new String[] { Integer.toString(MainMenu.idAuto) };
        mCursor = mContent.query(CONTENT_URI_BOOKING, null, selection, selectionArgs, null);
        //Log.e("MY_LOG", Integer.toString(mCursor.getColumnCount()));
        mCursor.moveToFirst();

        if (!mCursor.isAfterLast()) {
            do {
                bookingArrayList.add(new Booking(mCursor.getString(1), mCursor.getString(2), mCursor.getString(3), mCursor.getString(4), mCursor.getString(5)));
                Log.e("MY_LOG", mCursor.getString(0));
                mCursor.moveToNext();
            } while (!mCursor.isAfterLast());
        }
        mCursor.close();

        BookingAdapter autoAdapter = new BookingAdapter(this, bookingArrayList);

        ListView lvMain = (ListView) findViewById(R.id.listViewBook);
        lvMain.setAdapter(autoAdapter);
        //lvMain.setOnItemClickListener(this);
    }

    public void onDelete(View v) {
        mContent = getContentResolver();
        mContent.delete(CONTENT_URI_AUTO, "_id = " + MainMenu.idAuto, null);
        Intent intent = new Intent(AutoInfo.this, AutoList.class);
        startActivity(intent);
        finish();
    }

    public void onNewBooking(View v) {
        Intent intent = new Intent(AutoInfo.this, NewBooking.class);
        startActivity(intent);
        finish();
    }
}
