package com.livia01px2019.shelter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BuildingPopup extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Event> mListEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_building_popup);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mListEvent = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.whereEqualTo("Location", "Isolation Building");
        query.whereEqualTo("Finished", false);
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
        });


        mAdapter = new BuildingAdapter(mListEvent, this);
        mRecyclerView.setAdapter(mAdapter);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.8), (int) (height*0.7));

    }

    public void close(View v){
        finish();

    }

    public void finished(View v){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.getInBackground("XKouXj5Vsy", new GetCallback<ParseObject>() {
            public void done(ParseObject gameScore, ParseException e) {
                if (e == null) {
                    // Now let's update it with some new data. In this case, only cheatMode and score
                    // will get sent to the Parse Cloud. playerName hasn't changed.
                    gameScore.put("Finished", true);
                    gameScore.saveInBackground();
                }
            }
        });
    }

    public void goNewEvent(View v) {
        Intent intent = new Intent(BuildingPopup.this, NewEventActivity.class);
        Log.d("Shelter", "go to new event");
        startActivity(intent);
    }
}
