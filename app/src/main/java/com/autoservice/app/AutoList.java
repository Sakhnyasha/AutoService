package com.autoservice.app;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by artem on 18.05.14.
 */
public class AutoList extends Activity implements AdapterView.OnItemClickListener {

    static final Uri CONTENT_URI_AUTO = Uri.parse("content://com.autoservice.app.AutoDBOpenHelper/auto");

    private ArrayList<Auto> autoArrayList = new ArrayList<Auto>();
    private ArrayList<Integer> idList = new ArrayList<Integer>();

    ContentResolver mContent;
    Cursor mCursor;

    String searchBy = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        searchBy = getIntent().getStringExtra("searchBy");
        //Log.e("WARNING",search);

        if (MainMenu.search == false) {
            mContent = getContentResolver();
            mCursor = mContent.query(CONTENT_URI_AUTO, null, null, null, null);
            //Log.e("MY_LOG", Integer.toString(mCursor.getColumnCount()));
            mCursor.moveToFirst();

            do {
                autoArrayList.add(new Auto(mCursor.getString(1), mCursor.getString(2), mCursor.getString(5), mCursor.getDouble(3), mCursor.getInt(4), mCursor.getInt(6)));
                idList.add(mCursor.getInt(0));
                Log.e("MY_LOG", mCursor.getString(0));
                mCursor.moveToNext();
            } while (!mCursor.isAfterLast());
            mCursor.close();

            AutoAdapter autoAdapter = new AutoAdapter(this, autoArrayList);

            ListView lvMain = (ListView) findViewById(R.id.list_view_auto);
            lvMain.setAdapter(autoAdapter);
            lvMain.setOnItemClickListener(this);
        }

        if (MainMenu.search == true) {
            mContent = getContentResolver();
            mCursor = mContent.query(CONTENT_URI_AUTO, null, null, null, null);
            //Log.e("MY_LOG", Integer.toString(mCursor.getColumnCount()));
            mCursor.moveToFirst();

            do {
                String testforsearch = new String(mCursor.getString(1) + mCursor.getString(2));
                Log.e("EAR",testforsearch);
                if (testforsearch.indexOf(searchBy) != -1) {
                    autoArrayList.add(new Auto(mCursor.getString(1), mCursor.getString(2), mCursor.getString(5), mCursor.getDouble(3), mCursor.getInt(4), mCursor.getInt(6)));
                    idList.add(Integer.parseInt(mCursor.getString(0)));
                }
                Log.e("MY_LOG", mCursor.getString(0));
                mCursor.moveToNext();
            } while (!mCursor.isAfterLast());
            mCursor.close();

            AutoAdapter autoAdapter = new AutoAdapter(this, autoArrayList);

            ListView lvMain = (ListView) findViewById(R.id.list_view_auto);
            lvMain.setAdapter(autoAdapter);
            lvMain.setOnItemClickListener(this);

            MainMenu.search = false;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        MainMenu.idAuto = idList.get(position);
        MainMenu.myAuto = autoArrayList.get(position);
        Intent intent = new Intent(AutoList.this, AutoInfo.class);
        startActivity(intent);
        finish();
    }
}
