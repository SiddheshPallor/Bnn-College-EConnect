package com.example.bnncollegee_connect;

import android.app.Application;

import com.onesignal.OneSignal;

public class bnnApp extends Application {

    private static final String ONESIGNAL_APP_ID = "69119db9-698f-4acf-9edb-0f323e73be94";

    @Override
    public void onCreate() {
        super.onCreate();

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}
