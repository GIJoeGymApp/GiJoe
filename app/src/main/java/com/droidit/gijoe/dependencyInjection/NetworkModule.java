package com.droidit.gijoe.dependencyInjection;

import com.droidit.backendless.DefaultLoginService;
import com.droidit.domain.login.LoginService;

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
