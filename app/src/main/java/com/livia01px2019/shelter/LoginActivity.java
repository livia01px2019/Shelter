package com.livia01px2019.shelter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ParseInstallation;
// Front End Dependencies
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView mUserNameView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        mUserNameView = (AutoCompleteTextView) findViewById(R.id.enter_username);
        mPasswordView = (EditText) findViewById(R.id.enter_password);

    }

    // Executed when Sign In button is pressed
    public void signInExistingUser(View v)   {
        Log.d("Shelter", "sign in pressed");
        ParseUser.logInInBackground(mUserNameView.getText().toString(), mPasswordView.getText().toString(),
                new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    // The user is logged in.
                    Intent intent = new Intent(LoginActivity.this, TabbedActivity.class);
                    Log.d("Shelter", "sign in successful");
                    finish();
                    startActivity(intent);
                } else {
                    // Signup failed.
                    Log.d("Shelter", "Login failed " + e.toString());
                }
            }
        });
    }

    // Executed when Register button pressed
    public void registerNewUser(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        Log.d("Shelter", "register page");
        finish();
        startActivity(intent);

    }

}
