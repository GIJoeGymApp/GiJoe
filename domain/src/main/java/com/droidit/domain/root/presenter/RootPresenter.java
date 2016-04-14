package com.droidit.domain.root.presenter;

import com.droidit.domain.root.RootView;
import com.droidit.domain.root.interactor.LoginInteractor;

import javax.inject.Inject;

/**
 * Created by V1rus on 07-Apr-16.
 */
public class RootPresenter {

    private final LoginInteractor mLoginInteractor;
    private RootView mRootView;

    @Inject
    public RootPresenter(LoginInteractor loginInteractor) {
        mLoginInteractor = loginInteractor;
    }

    public void setView(RootView rootView) {
        this.mRootView = rootView;
    }

    public void onCreate() {
        mRootView.loadCurrentListFragment();
    }
}
