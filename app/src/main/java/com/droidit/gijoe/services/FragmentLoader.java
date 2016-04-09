package com.droidit.gijoe.services;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

/**
 * Created by V1rus on 09-Apr-16.
 */
public class FragmentLoader {

    @Inject
    public FragmentLoader() {
    }

    public void initActivityWithFragment(FragmentManager fragmentManager, int idOfView, Fragment fragmentToInflate) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(idOfView, fragmentToInflate);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void replaceFragments(FragmentManager fragmentManager, int idOfView, Fragment fragmentToInflate) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(idOfView, fragmentToInflate);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void replaceFragments(FragmentManager fragmentManager, int idOfView, Fragment fragmentToInflate, int slideInAnimation, int slideOutAnimation) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(slideInAnimation, slideOutAnimation);
        fragmentTransaction.replace(idOfView, fragmentToInflate);
        fragmentTransaction.commitAllowingStateLoss();
    }

    public void removeFragment(FragmentManager fragmentManager, Fragment fragment) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }
}
