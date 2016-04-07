package com.droidit.root.presenter;

import com.droidit.root.RootView;

import javax.inject.Inject;

/**
 * Created by V1rus on 07-Apr-16.
 */
public class RootPresenter {

    private RootView mRootView;

    @Inject
    public RootPresenter() {
    }

    public void setView(RootView rootView) {
        this.mRootView = rootView;
    }

    public void onTestButtonClicked() {

    }
}
