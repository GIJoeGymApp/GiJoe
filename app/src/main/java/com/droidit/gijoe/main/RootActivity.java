package com.droidit.gijoe.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.droidit.gijoe.R;
import com.droidit.gijoe.dependencyInjection.DaggerAppComponent;
import com.droidit.gijoe.dependencyInjection.MainComponent;
import com.droidit.root.RootView;

import butterknife.OnClick;

public class RootActivity extends AppCompatActivity implements RootView {

    private MainComponent mMainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);


    }

    @OnClick(R.id.test_btn)
    public void onTestButtonClicked() {

    }
}
