package com.droidit.datastore;

import com.backendless.BackendlessUser;

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
    public void registerUser(String userName, String password) {
        BackendlessUser backendlessUser = new BackendlessUser();
        backendlessUser.setEmail(userName);
        backendlessUser.setPassword(password);

        mBackEndLessManager.provideUserService().register(backendlessUser);

    }
}
