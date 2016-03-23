package com.devcamp.yapp.db.DB;

import android.app.Application;
import android.content.Context;

/**
 * Created by home on 2016-02-25.
 */
public class MyApplication extends Application {

    static Context ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;
    }

    public static Context getAppContext(){
        return ctx;
    }
}
