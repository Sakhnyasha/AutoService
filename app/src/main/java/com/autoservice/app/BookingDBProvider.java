package com.autoservice.app;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.widget.Toast;

import java.sql.SQLException;

/**
 * Created by artem on 18.05.14.
 */
public class BookingDBProvider extends ContentProvider {

    static final Uri CONTENT_URI_BOOKING = Uri.parse("content://com.autoservice.app.BookingDBOpenHelper/book");

    public static String BOOKING = "Booking";

    SQLiteDatabase sqLiteDatabase;

    @Override
    public boolean onCreate() {
        sqLiteDatabase = new BookingDBOpenHelper(getContext()).getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = sqLiteDatabase.query(BookingDBOpenHelper.BOOKING, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        ContentValues myValues = new ContentValues(values);
        long rowId = sqLiteDatabase.insert(BookingDBOpenHelper.BOOKING, BookingDBOpenHelper.USER_NAME, myValues);

        if (rowId > 0) {
            Uri url = ContentUris.withAppendedId(CONTENT_URI_BOOKING, rowId);
            getContext().getContentResolver().notifyChange(url, null);
            Toast.makeText(getContext(), "Результат занесен в таблицу", Toast.LENGTH_SHORT).show();

            return url;
        } else {
            try {
                throw  new SQLException("Failed to insert row!");
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Failed to insert data", Toast.LENGTH_SHORT).show();
                return null;
            }
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int retVal = sqLiteDatabase.delete(BookingDBOpenHelper.BOOKING, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);

        return retVal;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
