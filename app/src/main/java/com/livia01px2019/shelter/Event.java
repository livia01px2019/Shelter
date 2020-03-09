package com.livia01px2019.shelter;

import android.widget.EditText;
import android.widget.Spinner;

import com.alamkanak.weekview.WeekViewEvent;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.Calendar;


public class Event extends WeekViewEvent {

    private String mEventDescription;
    private String mDog;
    private String mPeople;
    private boolean mFinished;

    public Event(long id, String name, String location, Calendar startTime, Calendar endTime,
                 String eventDescription, String dog, String people) {
        super(id, name, location, startTime, endTime);
        mEventDescription = eventDescription;
        mDog = dog;
        mPeople = people;
        mFinished = false;
    }

    public Event() {
        super();
    }

    public String getEventDescription() {
        return mEventDescription;
    }

    public String getDog() {
        return mDog;
    }

    public String getPeople() {
        return mPeople;
    }

    public void push() {
        ParseObject newEvent = new ParseObject("Event");
        newEvent.put("Name", this.getName());
        newEvent.put("Description", mEventDescription);
        newEvent.put("Location", this.getLocation());
        newEvent.put("Dogs", mDog);
        newEvent.put("People", mPeople);
        newEvent.put("StartTime", this.getStartTime().getTime());
        newEvent.put("EndTime", this.getEndTime().getTime());
        newEvent.put("Finished", this.mFinished);
        newEvent.saveInBackground();
    }
}
