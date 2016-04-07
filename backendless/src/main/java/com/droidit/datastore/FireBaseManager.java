package com.droidit.datastore;

import android.content.Context;

import com.firebase.client.Firebase;

import javax.inject.Inject;

/**
 * Created by V1rus on 31-Mar-16.
 */
public class FireBaseManager {

    private Context mContext;
    private final String FIREBASE_ROOT_URL = "https://scorching-fire-5451.firebaseio.com/";

    @Inject
    public FireBaseManager(Context context) {
        this.mContext = context;
        Firebase.setAndroidContext(mContext);
    }

    public Firebase ProvideFireBase() {
        return new Firebase(FIREBASE_ROOT_URL);
    }


}
