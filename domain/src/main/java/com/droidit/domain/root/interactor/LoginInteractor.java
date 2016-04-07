package com.droidit.domain.root.interactor;

import com.droidit.domain.login.LoginService;

import javax.inject.Inject;

/**
 * Created by V1rus on 07-Apr-16.
 */
public class LoginInteractor {

    private final LoginService mLoginService;

    @Inject
    public LoginInteractor(LoginService loginService) {
        mLoginService = loginService;
    }

    public void registerUser() {
        mLoginService.registerUser("h-annie@live.co.za", "123", new LoginService.LoginServiceCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure() {

            }
        });
    }
}
