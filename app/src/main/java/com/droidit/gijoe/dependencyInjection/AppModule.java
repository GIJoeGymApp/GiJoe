package com.droidit.gijoe.dependencyInjection;

import android.app.Application;
import android.content.Context;

import com.droidit.datastore.FireBaseManager;
import com.firebase.client.Firebase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by V1rus on 31-Mar-16.
 */
@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    public Firebase provideFireBase(FireBaseManager fireBaseManager) {
        return fireBaseManager.ProvideFireBase();
    }
}
