package com.droidit.backendless;

import android.util.Log;

import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.droidit.domain.login.LoginService;

import javax.inject.Inject;

/**
 * Created by V1rus on 07-Apr-16.
 */
public class DefaultLoginService implements LoginService {

    private final BackEndLessManager mBackEndLessManager;

    @Inject
    public DefaultLoginService(BackEndLessManager backEndLessManager) {
        mBackEndLessManager = backEndLessManager;
    }

    @Override
    public void registerUser(String userName, String password, LoginServiceCallback callback) {
        BackendlessUser backendlessUser = new BackendlessUser();
        backendlessUser.setEmail(userName);
        backendlessUser.setPassword(password);

        mBackEndLessManager.provideUserService().register(backendlessUser, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser backendlessUser) {
                Log.i("Registration", backendlessUser.getEmail() + " successfully registered");
            }

            @Override
            public void handleFault(BackendlessFault backendlessFault) {
                Log.i("Registration", "failed = " + backendlessFault.toString());
            }
        });

    }
}
