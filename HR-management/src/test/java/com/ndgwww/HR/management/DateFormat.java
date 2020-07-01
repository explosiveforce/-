package com.ndgwww.HR.management;

import java.text.SimpleDateFormat;

public class DateFormat {
    public static void main(String[] args) {
        long TimeMillis = System.currentTimeMillis();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date_1 = df.format(TimeMillis);
        System.out.println(date_1);
    }
}
