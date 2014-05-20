package com.autoservice.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by artem on 18.05.14.
 */
public class NewBooking extends Activity {

    static final Uri CONTENT_URI_BOOKING = Uri.parse("content://com.autoservice.app.BookingDBOpenHelper/book");

    public static String BOOKING = "Booking";
    public static String USER_NAME = "userName";
    public static String UDER_EMAIL = "userEmail";
    public static String USER_PHONE = "userPhone";
    public static String BEGIN = "begin";
    public static String END = "end";
    public static String AUTO_ID = "auto_id";

    String begin = "";
    String end = "";
    String userEMail = "";
    String userName = "";
    String userPhone = "";

    ContentResolver mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_booking);

    }

    public void addBooking(View v) {
        userName = ((EditText) findViewById(R.id.name)).getText().toString();
        userEMail = ((EditText) findViewById(R.id.email)).getText().toString();
        userPhone = ((EditText) findViewById(R.id.phone)).getText().toString();
        begin = ((EditText) findViewById(R.id.begin_day)).getText().toString();
        end = ((EditText) findViewById(R.id.end_day)).getText().toString();

        mContent = this.getContentResolver();

        ContentValues values = new ContentValues(2);

        values.put(USER_NAME, userName);
        values.put(UDER_EMAIL, userEMail);
        values.put(USER_PHONE, userPhone);
        values.put(BEGIN, begin);
        values.put(END, end);
        values.put(AUTO_ID, MainMenu.idAuto);

        mContent.insert(CONTENT_URI_BOOKING, values);

        Toast.makeText(this, "Зарезервировано", Toast.LENGTH_SHORT).show();
        finish();
    }
}
