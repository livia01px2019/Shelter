package com.livia01px2019.shelter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

        private RadioGroup mRadioGroup;
        private RadioButton mRadioButton;
        private RadioButton mRadioButton2;
        private AutoCompleteTextView mUsernameView;
        private AutoCompleteTextView mEmailView;
        private EditText mPasswordView;
        private EditText mConfirmPasswordView;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            mRadioButton = (RadioButton) findViewById(R.id.radioButton);
            mRadioButton2 = (RadioButton) findViewById(R.id.radioButton2);
            mUsernameView = (AutoCompleteTextView) findViewById(R.id.username);
            mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
            mPasswordView = (EditText) findViewById(R.id.password);
            mConfirmPasswordView = (EditText) findViewById(R.id.confirm_password);

        }

        public void goBack(View v){
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            Log.d("Shelter", "go back to login page");
            finish();
            startActivity(intent);
        }

        public void finishRegister(View v){
            ParseUser currentUser = ParseUser.getCurrentUser();
            if (currentUser != null) {
                ParseUser.logOut();
            }
            Log.d("Shelter", "register pushed.");
            if(!mPasswordView.getText().toString().equals(mConfirmPasswordView.getText().toString())){
                Log.d("Shelter", mPasswordView.getText().toString());
                Toast.makeText(this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
            }
            else if (mUsernameView.getText().toString().length()==0) {
                Toast.makeText(this, "Please enter your username.", Toast.LENGTH_SHORT).show();
            }
            else if (mPasswordView.getText().toString().length()==0) {
                Toast.makeText(this, "Please enter your password.", Toast.LENGTH_SHORT).show();
            }
            else if (mEmailView.getText().toString().length()==0) {
                Toast.makeText(this, "Please enter your email address.", Toast.LENGTH_SHORT).show();
            }
            else if (!mRadioButton.isChecked()&&!mRadioButton2.isChecked()) {
                Toast.makeText(this, "Please enter whether you are an employee or guest.", Toast.LENGTH_SHORT).show();
            }
            else{
                ParseUser newUser = new ParseUser();
                newUser.setUsername(mUsernameView.getText().toString());
                newUser.setPassword(mPasswordView.getText().toString());
                newUser.setEmail(mEmailView.getText().toString());
                newUser.put("Employee", mRadioButton.isChecked());
                newUser.put("Score", 0);
                newUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e == null) {
                            Intent intent = new Intent(RegisterActivity.this, TabbedActivity.class);
                            Log.d("Shelter", "go back to login page");
                            finish();
                            startActivity(intent);
                        } else {
                            // Sign up didn't succeed. Look at the ParseException
                            // to figure out what went wrong
                            Log.d("Shelter", "something went wrong");
                            Log.d("Shelter", e.toString());
                        }
                    }
                });

            }
        }


}
