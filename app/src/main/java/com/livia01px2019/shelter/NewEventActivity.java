package com.livia01px2019.shelter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.parse.ParseObject;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewEventActivity extends AppCompatActivity {

    EditText mEventName;
    EditText mEventDescription;
    Spinner mLocationSpinner;
    Spinner mDogSpinner;
    EditText mStartTime;
    EditText mStartDate;
    EditText mEndTime;
    EditText mEndDate;
    Spinner mVolunteerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        mEventDescription = (EditText) findViewById(R.id.enter_event_description);
        mEventName = (EditText) findViewById(R.id.enter_event_name);
        mLocationSpinner = (Spinner) findViewById(R.id.location_spinner);
        mDogSpinner = (Spinner) findViewById(R.id.dog_spinner);
        mStartDate = (EditText) findViewById(R.id.start_date);
        mStartTime = (EditText) findViewById(R.id.start_time);
        mEndTime = (EditText) findViewById(R.id.end_time);
        mEndDate = (EditText) findViewById(R.id.end_date);
        mVolunteerSpinner = (Spinner) findViewById(R.id.volunteer_spinner);


    }

    public void cancel(View v) {
        Intent intent = new Intent(NewEventActivity.this, TabbedActivity.class);
        Log.d("Shelter", "cancel newevent");
        finish();
        startActivity(intent);
    }

    public void addEvent (View v) throws ParseException {
        String startDateText = mStartDate.getText().toString();
        String startTimeText = mStartTime.getText().toString();
        String ts1 = startDateText + " " + startTimeText;

        String pattern = "MM/dd/yyyy HH:mm";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date1 = sdf.parse(ts1);
        Calendar startTime = Calendar.getInstance();
        startTime.setTime(date1);

        String endDateText = mEndDate.getText().toString();
        String endTimeText = mEndTime.getText().toString();
        String ts2 = endDateText + " " + endTimeText;

        Date date2 = sdf.parse(ts2);
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(date2);


        Event newEvent = new Event(
                1,
                mEventName.getText().toString(),
                mLocationSpinner.getSelectedItem().toString(),
                startTime,
                endTime,
                mEventDescription.getText().toString(),
                mDogSpinner.getSelectedItem().toString(),
                mVolunteerSpinner.getSelectedItem().toString()
        );
        //newEvent.push();
        Log.d("Shelter", "create new event");
        finish();
    }
}
