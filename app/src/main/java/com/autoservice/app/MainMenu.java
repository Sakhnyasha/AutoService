package com.autoservice.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainMenu extends Activity {

    public static boolean search = false;

    public static Auto myAuto;

    public static int idAuto = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void toCatalog(View v) {
        Intent intent = new Intent(MainMenu.this, AutoList.class);
        startActivity(intent);
    }

    public void toExit(View v) {
        finish();
    }

    public void toNewCar(View v) {
        Intent intent = new Intent(MainMenu.this, NewCar.class);
        startActivity(intent);
    }

    public void toSearch(View v) {
        Intent intent = new Intent(MainMenu.this, AutoSearch.class);
        startActivity(intent);
    }
}
