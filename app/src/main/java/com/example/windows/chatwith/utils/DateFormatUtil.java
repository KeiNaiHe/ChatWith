package com.example.windows.chatwith.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;

/**
 * Created by Windows on 2018/6/29.
 */

public class DateFormatUtil {
    public static String getDate(long time) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        return simpleDateFormat.format(time);
    }
}
