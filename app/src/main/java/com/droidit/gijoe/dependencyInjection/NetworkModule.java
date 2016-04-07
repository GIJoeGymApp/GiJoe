package com.droidit.gijoe.dependencyInjection;

import com.droidit.datastore.DefaultLoginService;
import com.droidit.datastore.LoginService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by V1rus on 07-Apr-16.
 */
@Module
public class NetworkModule {

    @Provides
    public LoginService provideLoginService(DefaultLoginService defaultLoginService) {
        return defaultLoginService;
    }
}
