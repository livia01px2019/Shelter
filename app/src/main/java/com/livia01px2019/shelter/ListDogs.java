package com.livia01px2019.shelter;

import com.parse.ParseObject;

public class ListDogs {

    private String mDogName;
    private String mDogLocation;
    private String mDogComments;

    public ListDogs(String dogName, String dogLocation, String dogComments) {
        mDogName = dogName;
        mDogLocation = dogLocation;
        mDogComments = dogComments;
    }

    public String getDogName() { return mDogName; }

    public String getDogLocation() { return mDogLocation; }

    public String getDogComments() { return mDogComments; }

    public void push() {
        ParseObject newDog = new ParseObject("Dog");
        newDog.put("Name", mDogName);
        newDog.put("Location", mDogLocation);
        newDog.put("Comments", mDogComments);
        newDog.saveInBackground();
    }
}
