package com.autoservice.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by artem on 18.05.14.
 */
public class AutoDBOpenHelper extends SQLiteOpenHelper implements BaseColumns {

    public static int VERSION = 1;
    public static String DB_NAME = "autoserv_auto.db";

    public static String AUTO = "Auto";
    public static String MANUFACTURER = "manufacturer";
    public static String MODEL = "model";
    public static String ENGINE_CAPACITY = "engineCapacity";
    public static String MAX_SPEED = "maxSpeed";
    public static String COLOR = "color";
    public static String MILEAGE = "mileage";

    public static String AUTO_DB_CREATED = "CREATE TABLE Auto (_id INTEGER PRIMARY KEY AUTOINCREMENT, manufacturer TEXT, model TEXT, engineCapacity REAL, maxSpeed INTEGER, color TEXT, mileage INTEGER);";

    public AutoDBOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AUTO_DB_CREATED);

        ContentValues values = new ContentValues();

        values.put(MANUFACTURER, "Manuf 1");
        values.put(MODEL, "Model 1");
        values.put(ENGINE_CAPACITY, 25.5);
        values.put(MAX_SPEED, 120);
        values.put(COLOR, "Red");
        values.put(MILEAGE, 1);
        db.insert(AUTO, null, values);

        values.put(MANUFACTURER, "Manuf 2");
        values.put(MODEL, "Model 2");
        values.put(ENGINE_CAPACITY, 31.7);
        values.put(MAX_SPEED, 180);
        values.put(COLOR, "Black");
        values.put(MILEAGE, 2);
        db.insert(AUTO, null, values);

        values.put(MANUFACTURER, "Manuf 3");
        values.put(MODEL, "Model 3");
        values.put(ENGINE_CAPACITY, 48.9);
        values.put(MAX_SPEED, 90);
        values.put(COLOR, "Green");
        values.put(MILEAGE, 3);
        db.insert(AUTO, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + AUTO);
        onCreate(db);
    }
}
