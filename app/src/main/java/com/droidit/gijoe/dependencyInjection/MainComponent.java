package com.droidit.gijoe.dependencyInjection;

import com.droidit.gijoe.main.RootActivity;

import dagger.Component;

/**
 * Created by V1rus on 07-Apr-16.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {NetworkModule.class})
public interface MainComponent {

    void inject(RootActivity rootActivity);
}
