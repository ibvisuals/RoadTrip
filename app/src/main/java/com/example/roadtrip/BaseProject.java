package com.example.roadtrip;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class BaseProject extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
