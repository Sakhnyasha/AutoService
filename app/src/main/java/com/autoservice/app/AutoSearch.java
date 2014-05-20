package com.autoservice.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by artem on 18.05.14.
 */
public class AutoSearch extends Activity {

    public String searchBy = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void Search(View v) {
        searchBy = ((EditText) findViewById(R.id.search)).getText().toString();
        Intent intent = new Intent(AutoSearch.this, AutoList.class);
        MainMenu.search = true;
        intent.putExtra("searchBy", searchBy);
        startActivity(intent);
        finish();
    }
}
