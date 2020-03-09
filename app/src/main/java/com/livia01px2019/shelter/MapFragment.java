package com.livia01px2019.shelter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MapFragment extends Fragment {
    private static final String TAG="MapFragment";
    private TextView mIsolation;
    private TextView mSkinDisease;
    private TextView mOld;
    private TextView mSmall1;
    private TextView mAdoption;
    private TextView mMid1;
    private TextView mLarge1;
    private TextView mLarge2;
    private TextView mMid2;
    private TextView mSmall2;
    private TextView mMid3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.map_fragment, container, false);

        mSkinDisease = (TextView) view.findViewById(R.id.skinDiseaseBuildingText);
        mSkinDisease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Shelter", "skin disease.");
            }
        });

        mOld = (TextView) view.findViewById(R.id.oldSickDisabledAreaText);
        mOld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Shelter", "old.");
            }
        });

        mSmall1 = (TextView) view.findViewById(R.id.smallDogArea1Text);
        mSmall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Shelter", "small 1.");
            }
        });

        mAdoption = (TextView) view.findViewById(R.id.adoptionAreaText);
        mAdoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Shelter", "adtopion.");
            }
        });

        mMid1 = (TextView) view.findViewById(R.id.midsizeDogArea1Text);
        mMid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Shelter", "mid 1.");
            }
        });

        mLarge1 = (TextView) view.findViewById(R.id.largeDogArea1Text);
        mLarge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Shelter", "large 1.");
            }
        });

        mLarge2 = (TextView) view.findViewById(R.id.largeDogArea2Text);
        mLarge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Shelter", "large 2.");
            }
        });

        mMid2 = (TextView) view.findViewById(R.id.midsizeDogArea2Text);
        mMid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Shelter", "mid 2.");
            }
        });

        mSmall2 = (TextView) view.findViewById(R.id.smallDogArea2Text);
        mSmall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Shelter", "small 2.");
            }
        });

        mMid3 = (TextView) view.findViewById(R.id.midsizeDogArea3Text);
        mMid3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Shelter", "mid 3.");
            }
        });

        return view;
    }


}
