package com.livia01px2019.shelter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabbedActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private CustomViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);
        Log.d("Shelter", "onCreate: starting");

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (CustomViewPager) findViewById(R.id.container);
        mViewPager.setSwipeable(false);
        setUpViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);


    }


    private void setUpViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PeopleFragment(), "People");
        adapter.addFragment(new DogsFragment(), "Dogs");
        adapter.addFragment(new CalendarFragment(), "Calendar");
        adapter.addFragment(new MapFragment(), "Map");
        viewPager.setAdapter(adapter);
    }

    public void goSettings(View v){
        Intent intent = new Intent(TabbedActivity.this, SettingsActivity.class);
        Log.d("Shelter", "go to settings");
        startActivity(intent);
    }

    public void goNewEvent(View v){
        Intent intent = new Intent(TabbedActivity.this, NewEventActivity.class);
        Log.d("Shelter", "go to new event");
        startActivity(intent);
    }
    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragementList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragementList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return mFragementList.get(position);
        }

        @Override
        public int getCount() {
            return mFragementList.size();
        }
    }

    public void addNewDog(View v){
        Intent intent = new Intent(TabbedActivity.this, NewDogActivity.class);
        Log.d("Shelter", "to new dog activity");
        startActivity(intent);
    }

    public void goToIsolation(View v){
        Intent intent = new Intent(TabbedActivity.this, BuildingPopup.class);
        Log.d("Shelter", "to building activity");
        startActivity(intent);
    }

    public void openPerson(View v){
        Intent intent = new Intent(TabbedActivity.this, PersonPopup.class);
        Log.d("Shelter", "to person activity");
        startActivity(intent);
    }

    public void openDog(View v){
        Intent intent = new Intent(TabbedActivity.this, DogPopup.class);
        Log.d("Shelter", "to person activity");
        startActivity(intent);
    }
}
