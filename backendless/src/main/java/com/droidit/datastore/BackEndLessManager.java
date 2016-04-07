package com.droidit.datastore;

import android.content.Context;

import com.backendless.Backendless;
import com.backendless.Persistence;
import com.backendless.UserService;

import javax.inject.Inject;

/**
 * Created by V1rus on 07-Apr-16.
 */
public class BackEndLessManager {

    private final String VERSION_CODE = "v1";
    private final String APP_UD = "BF8B260F-F38A-18AD-FFB4-274A7EC30F00";
    private final String APP_SC = "B3B4C78B-FC1A-5869-FF1F-9DEC67180300";
    private Context mContext;

    @Inject
    public BackEndLessManager(Context context) {
        this.mContext = context;
    }

    public void registerBackEndLess() {
        Backendless.initApp(mContext, APP_UD, APP_SC, VERSION_CODE);
    }

    public UserService provideUserService() {
        return Backendless.UserService;
    }
}
