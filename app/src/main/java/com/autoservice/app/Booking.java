package com.autoservice.app;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by artem on 17.05.14.
 */

public class Booking {

    String begin = "";
    String end = "";
    String userEMail = "";
    String userName = "";
    String userPhone = "";

    public Booking(String _name, String _phone, String _email, String _begin, String _end) {
        begin = _begin;
        end = _end;
        userName = _name;
        userEMail = _email;
        userPhone = _phone;
    }

}
