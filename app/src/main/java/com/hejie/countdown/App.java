package com.hejie.countdown;

import android.app.Application;

/**
 * Created by jay on 17-12-7.
 */

public class App extends Application {

    private static App instance;

    public static App get() {
        return instance;
    }

    public App(){
        super();
        instance = this;
    }
}
