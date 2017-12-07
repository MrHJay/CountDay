package com.hejie.countdown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hejie.countdown.cal.CountdownCalc;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView countText = findViewById(R.id.day_count);
        Date date = new Date();
        int count = CountdownCalc.getInstance().calcDayCount(date);
        countText.setText(String.valueOf(count));
    }
}
