package com.droidit.gijoe.dependencyInjection;

import android.content.Context;

import com.droidit.gijoe.GiJoeApplication;
import com.firebase.client.Firebase;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by V1rus on 31-Mar-16.
 */
@Singleton
@Component (modules = AppModule.class)
public interface AppComponent {

    void injectApplication(GiJoeApplication giJoeApplication);

    Context gIContext();

    Firebase fireBase();
}
