package com.example.sampledagger2recyclerview;

import android.app.Activity;
import android.app.Application;

import com.example.sampledagger2recyclerview.component.ApplicationComponent;
import com.example.sampledagger2recyclerview.component.DaggerApplicationComponent;
import com.example.sampledagger2recyclerview.module.ContextModule;

public class AppApplication extends Application {

    ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
        .contextModule(new ContextModule(this)).build();

        component.applicationInject(this);
    }


    public static AppApplication get(Activity activity){
        return (AppApplication)activity.getApplication();
    }

    public  ApplicationComponent getApplicationComponent(){
        return component;
    }
}
