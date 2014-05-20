package com.autoservice.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by artem on 18.05.14.
 */
public class AutoAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Auto> autoList;

    public AutoAdapter(Context _context, ArrayList<Auto> _autoList) {
        context = _context;
        autoList = _autoList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return autoList.size();
    }

    @Override
    public Object getItem(int position) {
        return autoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.activity_listitem, parent, false);
        }

        Auto p = (Auto) getItem(position);

        ((TextView) view.findViewById(R.id.textListItem)).setText(p.manufacturer);
        return view;
    }
}
