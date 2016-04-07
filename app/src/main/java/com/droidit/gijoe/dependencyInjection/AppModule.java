package com.droidit.gijoe.dependencyInjection;

import android.content.Context;

import com.droidit.gijoe.GiJoeApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by V1rus on 31-Mar-16.
 */
@Module
public class AppModule {

    private final GiJoeApplication mApplication;

    public AppModule(GiJoeApplication mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }
}
