package com.example.prit.silverlabsdemoapp;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.example.prit.silverlabsdemoapp.databinding.AppDataBindingComponent;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }
}
