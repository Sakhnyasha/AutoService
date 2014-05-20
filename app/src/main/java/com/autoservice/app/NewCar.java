package com.autoservice.app;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by artem on 18.05.14.
 */
public class NewCar extends Activity {

    static final Uri CONTENT_URI_AUTO = Uri.parse("content://com.autoservice.app.AutoDBOpenHelper/auto");

    public static String MANUFACTURER = "manufacturer";
    public static String MODEL = "model";
    public static String ENGINE_CAPACITY = "engineCapacity";
    public static String MAX_SPEED = "maxSpeed";
    public static String COLOR = "color";
    public static String MILEAGE = "mileage";

    String manufacturer;
    String model;
    double engineCapacity;
    int maxSpeed;
    String color;
    int mileage;

    ContentResolver mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car);
    }

    public void addCar(View v) {
        manufacturer = ((EditText) findViewById(R.id.manufacturer)).getText().toString();
        model = ((EditText) findViewById(R.id.model)).getText().toString();
        engineCapacity = Double.parseDouble(((EditText) findViewById(R.id.en_cap)).getText().toString());
        maxSpeed = Integer.parseInt(((EditText) findViewById(R.id.max_speed)).getText().toString());
        color = ((EditText) findViewById(R.id.color)).getText().toString();
        mileage = Integer.parseInt(((EditText) findViewById(R.id.milage)).getText().toString());

        mContent = this.getContentResolver();

        ContentValues values = new ContentValues(2);

        values.put(MANUFACTURER, manufacturer);
        values.put(MODEL, model);
        values.put(ENGINE_CAPACITY, engineCapacity);
        values.put(MAX_SPEED, maxSpeed);
        values.put(COLOR, color);
        values.put(MILEAGE, mileage);

        mContent.insert(CONTENT_URI_AUTO, values);
    }
}
