package com.livia01px2019.shelter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.parse.ParseObject;

public class NewDogActivity extends AppCompatActivity {

    EditText mDogName;
    Spinner mLocationSpinner;
    EditText mComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdog);

        mDogName = (EditText) findViewById(R.id.enter_dog_name);
        mLocationSpinner = (Spinner) findViewById(R.id.location_spinner);
        mComments = (EditText) findViewById(R.id.enter_comments);

    }

    public void cancel(View v) {
        Intent intent = new Intent(NewDogActivity.this, TabbedActivity.class);
        Log.d("Shelter", "cancel newdog");
        finish();
        startActivity(intent);
    }

    public void addDog(View v) {
        ListDogs newDog = new ListDogs(mDogName.getText().toString(), mLocationSpinner.getSelectedItem().toString(), mComments.getText().toString());
        newDog.push();
        Log.d("Shelter", "cancel newdog");
        finish();
    }
}
