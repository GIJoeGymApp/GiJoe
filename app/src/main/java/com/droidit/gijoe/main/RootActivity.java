package com.droidit.gijoe.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.droidit.gijoe.GiJoeApplication;
import com.droidit.gijoe.R;
import com.droidit.gijoe.currentlist.CurrentListFragment;
import com.droidit.gijoe.dependencyInjection.DaggerMainComponent;
import com.droidit.gijoe.dependencyInjection.MainComponent;
import com.droidit.gijoe.dependencyInjection.NetworkModule;
import com.droidit.domain.root.RootView;
import com.droidit.domain.root.presenter.RootPresenter;
import com.droidit.gijoe.services.FragmentLoader;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class RootActivity extends AppCompatActivity implements RootView {

    private MainComponent mMainComponent;

    @Inject
    RootPresenter mRootPresenter;

    @Inject
    FragmentLoader mFragmentLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        ButterKnife.bind(this);
        initMainComponent();
        mRootPresenter.setView(this);
        mRootPresenter.onCreate();
    }

    private void initMainComponent() {
        mMainComponent = DaggerMainComponent.builder()
                .appComponent(((GiJoeApplication) this.getApplication()).getAppComponent())
                .networkModule(new NetworkModule())
                .build();

        mMainComponent.inject(this);
    }


    @Override
    public void loadCurrentListFragment() {
        mFragmentLoader.initActivityWithFragment(getSupportFragmentManager(), R.id.root_fragment_holder, new CurrentListFragment());
    }
}
