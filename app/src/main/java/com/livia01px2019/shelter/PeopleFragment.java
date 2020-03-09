package com.livia01px2019.shelter;

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
import android.widget.Button;

import com.parse.FindCallback;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


public class PeopleFragment extends Fragment {
    private static final String TAG="PeopleFragment";
    View view;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<ListPeople> mListPeople;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.people_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mAdapter = new PeopleAdapter(mListPeople, getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mListPeople = new ArrayList<>();
        ParseQuery<ParseUser> query = ParseUser.getQuery();
        ParseUser currentUser = ParseUser.getCurrentUser();
        if(currentUser.get("Employee").equals(true)){
            query.whereEqualTo("Employee", true);
        }
        else {
            query.whereEqualTo("Employee", false);
        }
        query.findInBackground(new FindCallback<ParseUser>() {
            public void done(List<ParseUser> objects, com.parse.ParseException e) {
                if (e == null) {
                    for(int i =0; i<objects.size(); i++){
                        ParseUser user = objects.get(i);
                        String userName = user.getUsername();
                        Log.d("Shelter", userName);
                        int userScore = user.getInt("Score");
                        ListPeople listPerson = new ListPeople(
                                userName,
                                userScore
                        );
                        mListPeople.add(listPerson);
                    }
                } else {
                    // Something went wrong.
                    Log.d("Shelter", "something went wrong.");
                }
            }
        });
/*        mListPeople = bubbleSort(mListPeople);
        for(int i = 0; i<mListPeople.size(); i++){
            Log.d("Shelter", mListPeople.get(i).toString());
        }*/

    }
    public List<ListPeople> bubbleSort(List<ListPeople> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getUserScore() > list.get(j + 1).getUserScore()) {
                    ListPeople temp = new ListPeople(
                            list.get(j).getUserName(),
                            list.get(j).getUserScore()
                    );
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

    public void merge(List<ListPeople> list, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        List<ListPeople> L = new ArrayList<ListPeople>();
        List<ListPeople> R = new ArrayList<ListPeople>();

        for (int i=0; i<n1; ++i) { L.add(list.get(l + i)); }
        for (int j=0; j<n2; ++j) { R.add(list.get(m + 1+ j)); }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L.get(i).getUserScore() <= R.get(j).getUserScore()) {
                list.set(k, L.get(i));
                i++;
            }
            else {
                list.set(k, L.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            list.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            list.set(k, L.get(j));
            j++;
            k++;
        }
    }

    public void mergeSort(List<ListPeople> list, int l, int r) {
        if (l < r) {
            int m = (l+r)/2;

            mergeSort(list, l, m);
            mergeSort(list , m+1, r);

            merge(list, l, m, r);
        }
    }
}
