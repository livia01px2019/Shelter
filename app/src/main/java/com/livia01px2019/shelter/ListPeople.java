package com.livia01px2019.shelter;

public class ListPeople {

    private String mUserName;
    private int mUserScore;

    public ListPeople(String userName, int userScore) {
        mUserName = userName;
        mUserScore = userScore;
    }

    public String getUserName() {
        return mUserName;
    }

    public int getUserScore() {
        return mUserScore;
    }

}
