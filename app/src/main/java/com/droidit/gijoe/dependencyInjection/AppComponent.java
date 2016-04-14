package com.droidit.gijoe.dependencyInjection;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by V1rus on 31-Mar-16.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Context gIContext();

}
