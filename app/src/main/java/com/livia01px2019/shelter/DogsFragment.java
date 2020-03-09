package com.livia01px2019.shelter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class DogsFragment extends Fragment {
    private static final String TAG="DogsFragment";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<ListDogs> mListDogs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dogs_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new DogsAdapter(mListDogs, getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListDogs = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Dog");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, com.parse.ParseException e) {
                if (e == null) {
                    for (int i = 0; i < objects.size(); i++) {
                        ParseObject dog = objects.get(i);
                        String dogName = dog.getString("Name");
                        Log.d("Shelter", dogName);
                        String dogLocation = dog.getString("Location");
                        String dogComments = dog.getString("Comments");
                        ListDogs listDogs = new ListDogs(
                                dogName,
                                dogLocation,
                                dogComments
                        );
                        mListDogs.add(listDogs);
                    }
                } else {
                    // Something went wrong.
                    Log.d("Shelter", "something went wrong. " + e.toString());
                }
            }
        });
    }

}
