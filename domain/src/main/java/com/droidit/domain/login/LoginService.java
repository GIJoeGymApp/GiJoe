package com.droidit.domain.login;

/**
 * Created by V1rus on 07-Apr-16.
 */
public interface LoginService {

    void registerUser(String userName, String password, LoginServiceCallback callback);

    interface LoginServiceCallback {
        void onSuccess();

        void onFailure();
    }
}
