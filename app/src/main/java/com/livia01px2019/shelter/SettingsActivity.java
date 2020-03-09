package com.livia01px2019.shelter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Event> mListEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mListEvent = new ArrayList<>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 11);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, 1);
        startTime.set(Calendar.YEAR, 2019);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR, 1);
        endTime.set(Calendar.MONTH, 2);

        //mListEvent.add(new Event(
        //        1,
        //        "New Event",
        //        "Isolation Building",
        //        startTime,
        //        endTime,
        //        "event",
        //        "d1",
        //        "g1"
        //));

        /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.whereEqualTo("Finished", false);
        //query.whereEqualTo("People", "g2");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {
                    for (int i = 0; i < objects.size(); i++) {
                        ParseObject event = objects.get(i);
                        String eventName = event.getString("Name");
                        Log.d("Shelter", eventName);
                        String description = event.getString("Description");
                        String location = event.getString("Location");
                        String dog = event.getString("Dogs");
                        String people = event.getString("People");
                        Calendar startTime = Calendar.getInstance();
                        startTime.setTime((Date)event.get("StartTime"));
                        Calendar endTime = Calendar.getInstance();
                        endTime.setTime((Date)event.get("EndTime"));
                        Event events = new Event(
                                1,
                                eventName,
                                location,
                                startTime,
                                endTime,
                                description,
                                dog,
                                people
                        );
                        mListEvent.add(events);
                    }
                } else {
                    // Something went wrong.
                    Log.d("Shelter", "something went wrong. " + e.toString());

                }
            }
        });*/


        mAdapter = new SettingsAdapter(mListEvent, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void logOut(View v){
        Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
        Log.d("Shelter", "go back to login page");
        ParseUser.logOut();
        finish();
        startActivity(intent);
    }

    public void goBack(View v){
        Intent intent = new Intent(SettingsActivity.this, TabbedActivity.class);
        Log.d("Shelter", "go back to tabbed page");
        finish();
        startActivity(intent);
    }

    public void goNewEvent(View v) {
        Intent intent = new Intent(SettingsActivity.this, NewEventActivity.class);
        Log.d("Shelter", "go to new event");
        startActivity(intent);
    }

}
