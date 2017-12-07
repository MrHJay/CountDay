package com.hejie.countdown.cal;

import android.content.Context;
import android.content.SharedPreferences;

import com.hejie.countdown.App;

import java.util.Date;

/**
 * Created by jay on 17-12-7.
 */

public class CountdownCalc {

    private SharedPreferences preferences;

    private static final String SHARED_PREFERENCE_NAME = "count_down_profile";
    public static final String KEY_START_DAY = "key_start_day";
    public static final long DEFAULT_START_DAY = 1318694400000L;

    private static CountdownCalc instance;

    public static CountdownCalc getInstance() {
        if (instance == null) {
            instance = new CountdownCalc(App.get());
        }
        return instance;
    }

    private CountdownCalc(Context context) {
        preferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public void setStartDay(Date day) {
        preferences.edit().putLong(KEY_START_DAY, day.getTime()).apply();
    }

    public long getStartDay() {
        return preferences.getLong(KEY_START_DAY, DEFAULT_START_DAY);
    }

    public int calcDayCount(Date date) {
        long startDay = getStartDay();
        return (int) ((date.getTime() - startDay) / (3600 * 24 * 1000)) + 1;
    }
}
