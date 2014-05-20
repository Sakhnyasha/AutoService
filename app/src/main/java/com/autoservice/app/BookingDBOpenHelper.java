package com.autoservice.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by artem on 18.05.14.
 */
public class BookingDBOpenHelper extends SQLiteOpenHelper implements BaseColumns {

    public static int VERSION = 1;
    public static String DB_NAME = "autoserv_booking.db";

    public static String BOOKING = "Booking";
    public static String USER_NAME = "userName";
    public static String UDER_EMAIL = "userEmail";
    public static String USER_PHONE = "userPhone";
    public static String BEGIN = "begin";
    public static String END = "end";
    public static String AUTO_ID = "auto_id";

    public static String BOOKING_DB_CREATED = "CREATE TABLE Booking (_id INTEGER PRIMARY KEY AUTOINCREMENT, userName TEXT, userEmail TEXT, userPhone TEXT, begin TEXT, end TEXT, auto_id INTEGER);";

    public BookingDBOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BOOKING_DB_CREATED);

        ContentValues values = new ContentValues();

        values.put(USER_NAME, "User 1");
        values.put(UDER_EMAIL, "Mail 1");
        values.put(USER_PHONE, "Phone 1");
        values.put(BEGIN, "22.01.2010");
        values.put(END, "24.01.2010");
        values.put(AUTO_ID, 1);
        db.insert(BOOKING, null, values);

        values.put(USER_NAME, "User 3");
        values.put(UDER_EMAIL, "Mail 3");
        values.put(USER_PHONE, "Phone 3");
        values.put(BEGIN, "15.05.2010");
        values.put(END, "24.06.2010");
        values.put(AUTO_ID, 3);
        db.insert(BOOKING, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + BOOKING);
        onCreate(db);
    }
}
