package com.livia01px2019.shelter;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

    private List<ListPeople> mListPeople;
    private Context mContext;

    public PeopleAdapter(List<ListPeople> listPeople, Context context) {
        mListPeople = listPeople;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_person, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListPeople listPeople = mListPeople.get(position);

        holder.textViewName.setText(listPeople.getUserName());
        holder.textViewScore.setText("Score: " + listPeople.getUserScore());
    }

    @Override
    public int getItemCount() {
        return mListPeople.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewScore;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.list_user_name);
            textViewScore = (TextView) itemView.findViewById(R.id.list_user_score);

        }
    }


}
