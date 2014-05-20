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
public class BookingAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Booking> bookingList;

    public BookingAdapter(Context _context, ArrayList<Booking> _bookingList) {
        context = _context;
        bookingList = _bookingList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return bookingList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookingList.get(position);
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

        Booking p = (Booking) getItem(position);

        ((TextView) view.findViewById(R.id.textListItem)).setText(p.userName+" "+p.userEMail+" "+p.userPhone+" "+p.begin+" "+p.end);
        return view;
    }
}
