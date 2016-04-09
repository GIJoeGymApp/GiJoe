package com.droidit.gijoe.currentlist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.droidit.gijoe.GiJoeApplication;
import com.droidit.gijoe.R;
import com.droidit.gijoe.dependencyInjection.DaggerMainComponent;
import com.droidit.gijoe.dependencyInjection.MainComponent;
import com.droidit.gijoe.dependencyInjection.NetworkModule;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentListFragment extends Fragment {

    private MainComponent mMainComponent;

    public CurrentListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_current_list, container, false);

        ButterKnife.bind(this, fragmentView);
        initMainComponent();


        return fragmentView;
    }

    private void initMainComponent() {
        mMainComponent = DaggerMainComponent.builder()
                .appComponent(((GiJoeApplication) this.getActivity().getApplication()).getAppComponent())
                .networkModule(new NetworkModule())
                .build();

        mMainComponent.inject(this);
    }


}
