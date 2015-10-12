package com.tinno.android.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.astuetz.PagerSlidingTabStrip;

/**
 * Created by android on 10/9/15.
 */
public class MainActivity extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;
    private ListView mDrawerListView;
    private ViewPager mViewPager;
    private String titles[] = new String[]{"Sample Tab 1", "Sample Tab 2", "Sample Tab 3", "Sample Tab 4"
            , "Sample Tab 5", "Sample Tab 6", "Sample Tab 7", "Sample Tab 8"};
    PagerSlidingTabStrip mPagerSlidingTabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if(mToolbar != null){
            mToolbar.setLogo(R.drawable.logo);
            mToolbar.setTitle("My Title");// 标题的文字需在setSupportActionBar之前，不然会无效
            mToolbar.setSubtitle("Sub Title");
            mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
            setSupportActionBar(mToolbar);
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerListView = (ListView)findViewById(R.id.mListView);

        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), titles));

        mPagerSlidingTabStrip = (PagerSlidingTabStrip)findViewById(R.id.tab_strip);
        mPagerSlidingTabStrip.setViewPager(mViewPager);
        mPagerSlidingTabStrip.setIndicatorColor(getResources().getColor(R.color.colorPrimaryDark));
        mPagerSlidingTabStrip.setIndicatorHeight(4);

        String[] values = new String[]{
                "DEFAULT", "RED", "BLUE", "MATERIAL GREY"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,android.R.id.text1,values);
        mDrawerListView.setAdapter(adapter);
        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        mDrawerListView.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                        mPagerSlidingTabStrip.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case 1:
                        mDrawerListView.setBackgroundColor(getResources().getColor(R.color.red));
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.red));
                        mPagerSlidingTabStrip.setBackgroundColor(getResources().getColor(R.color.red));
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case 2:
                        mDrawerListView.setBackgroundColor(getResources().getColor(R.color.blue));
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.blue));
                        mPagerSlidingTabStrip.setBackgroundColor(getResources().getColor(R.color.blue));
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case 3:
                        mDrawerListView.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
                        mPagerSlidingTabStrip.setBackgroundColor(getResources().getColor(R.color.material_blue_grey_800));
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
