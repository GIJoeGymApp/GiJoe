package com.droidit.gijoe;

import android.app.Application;

import com.droidit.gijoe.dependencyInjection.AppComponent;
import com.droidit.gijoe.dependencyInjection.AppModule;
import com.droidit.gijoe.dependencyInjection.DaggerAppComponent;

/**
 * Created by V1rus on 31-Mar-16.
 */
public class GiJoeApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent =  DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
