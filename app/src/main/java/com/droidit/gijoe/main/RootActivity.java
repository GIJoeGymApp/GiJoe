package com.droidit.gijoe.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.droidit.gijoe.GiJoeApplication;
import com.droidit.gijoe.R;
import com.droidit.gijoe.dependencyInjection.DaggerAppComponent;
import com.droidit.gijoe.dependencyInjection.DaggerMainComponent;
import com.droidit.gijoe.dependencyInjection.MainComponent;
import com.droidit.gijoe.dependencyInjection.NetworkModule;
import com.droidit.domain.root.RootView;
import com.droidit.domain.root.presenter.RootPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RootActivity extends AppCompatActivity implements RootView {

    private MainComponent mMainComponent;

    @Inject
    RootPresenter mRootPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        ButterKnife.bind(this);
        initMainComponent();
    }

    private void initMainComponent() {
        mMainComponent = DaggerMainComponent.builder()
                .appComponent(((GiJoeApplication) this.getApplication()).getAppComponent())
                .networkModule(new NetworkModule())
                .build();

        mMainComponent.inject(this);
    }

    @OnClick(R.id.test_btn)
    public void onTestButtonClicked() {
        mRootPresenter.onTestButtonClicked();
    }
}
