package com.example.aaart.reminder;

import android.app.Activity;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewParent;

import adapterTabLayout.TabsPagerFragment;

public class MainActivity extends AppCompatActivity {

    private static int LAYOUT = R.layout.activity_main;
    private Toolbar mToolBar;
    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        iniToolbar();
        initNavigationView();
        initTab();
    }

    private void iniToolbar() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mToolBar.setTitle(R.string.app_name);
        mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        mToolBar.inflateMenu(R.menu.menu);
    }

    private void initNavigationView() {
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.nav_open, R.string.nav_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                 switch (menuItem.getItemId()){
                    case R.id.navView:
                        showNotificationTab();
                }
                return true;
            }
        });
    }

    private void initTab() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        TabsPagerFragment tpf = new TabsPagerFragment(getSupportFragmentManager());

        mViewPager.setAdapter(tpf);

        TabLayout mTabLayout = (TabLayout)findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public void showNotificationTab () {
        mViewPager.setCurrentItem(Constants.TAB_TWO);
    }

}
