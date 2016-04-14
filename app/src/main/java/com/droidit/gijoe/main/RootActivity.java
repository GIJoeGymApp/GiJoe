package com.droidit.gijoe.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.droidit.domain.root.RootView;
import com.droidit.domain.root.presenter.RootPresenter;
import com.droidit.gijoe.GiJoeApplication;
import com.droidit.gijoe.R;
import com.droidit.gijoe.allworkouts.WorkoutListFragment;
import com.droidit.gijoe.currentlist.CurrentListFragment;
import com.droidit.gijoe.dependencyInjection.DaggerMainComponent;
import com.droidit.gijoe.dependencyInjection.MainComponent;
import com.droidit.gijoe.dependencyInjection.NetworkModule;
import com.droidit.gijoe.services.FragmentLoader;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RootActivity extends AppCompatActivity implements RootView {

    private MainComponent mMainComponent;

    @Bind(R.id.root_actionbar)
    Toolbar root_actionbar;

    @Bind(R.id.root_navigation_view)
    NavigationView root_navigation_view;

    @Bind(R.id.root_drawer_layout)
    DrawerLayout root_drawer_layout;

    @Inject
    RootPresenter mRootPresenter;

    @Inject
    FragmentLoader mFragmentLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        ButterKnife.bind(this);
        initMainComponent();
        mRootPresenter.setView(this);
        mRootPresenter.onCreate();
    }

    private void initMainComponent() {
        mMainComponent = DaggerMainComponent.builder()
                .appComponent(((GiJoeApplication) this.getApplication()).getAppComponent())
                .networkModule(new NetworkModule())
                .build();

        mMainComponent.inject(this);
    }


    @Override
    public void loadCurrentListFragment() {
        mFragmentLoader.replaceFragments(getSupportFragmentManager(), R.id.root_fragment_holder, new CurrentListFragment());
    }

    @Override
    public void loadWorkoutListFragment() {
        mFragmentLoader.replaceFragments(getSupportFragmentManager(), R.id.root_fragment_holder, new WorkoutListFragment());
    }

    @Override
    public void setupToolbarAndMenu() {
        setSupportActionBar(root_actionbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        root_navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getTitle().toString()) {
                    case "Current":
                        mRootPresenter.currentWorkoutMenuItemClicked();
                        break;
                    case "Workouts":
                        mRootPresenter.workoutListMenuItemClicked();
                        break;
                    default:
                        mRootPresenter.currentWorkoutMenuItemClicked();
                        break;
                }

                root_drawer_layout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                root_drawer_layout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
