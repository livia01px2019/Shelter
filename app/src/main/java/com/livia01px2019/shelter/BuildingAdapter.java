package com.livia01px2019.shelter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class BuildingAdapter extends RecyclerView.Adapter<BuildingAdapter.ViewHolder> {

    private List<Event> mListEvents;
    private Context mContext;

    public BuildingAdapter(List<Event> listEvents, Context context) {
        mListEvents = listEvents;
        mContext = context;
    }

    @NonNull
    @Override
    public BuildingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_events, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BuildingAdapter.ViewHolder holder, int position) {
        Event event = mListEvents.get(position);

        holder.textViewName.setText(event.getName());
        holder.textViewDog.setText("Dog: " + event.getDog());
        holder.textViewLocation.setText("Location: " + event.getLocation());
        holder.textViewStartTime.setText("Start Time: " + event.getStartTime().getTime());
        holder.textViewEndTime.setText("End Time: " + event.getEndTime().getTime());
        holder.textViewVolunteer.setText("Volunteer: " + event.getPeople());

    }

    @Override
    public int getItemCount() {
        return mListEvents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewDog;
        public TextView textViewLocation;
        public TextView textViewStartTime;
        public TextView textViewEndTime;
        public TextView textViewVolunteer;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.list_event_name);
            textViewDog = (TextView) itemView.findViewById(R.id.list_dog);
            textViewLocation = (TextView) itemView.findViewById(R.id.list_location);
            textViewStartTime = (TextView) itemView.findViewById(R.id.list_startTime);
            textViewEndTime = (TextView) itemView.findViewById(R.id.list_endTime);
            textViewVolunteer = (TextView) itemView.findViewById(R.id.list_volunteers);


        }
    }


}