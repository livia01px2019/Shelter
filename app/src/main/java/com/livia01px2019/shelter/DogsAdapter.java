package com.livia01px2019.shelter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {

    private List<ListDogs> mListDogs;
    private Context mContext;

    public DogsAdapter(List<ListDogs> listDogs, Context context) {
        mListDogs = listDogs;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_dogs, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListDogs listDogs = mListDogs.get(position);

        holder.textViewName.setText(listDogs.getDogName());
        holder.textViewLocation.setText("Location: " + listDogs.getDogLocation());
    }

    @Override
    public int getItemCount() {
        return mListDogs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewLocation;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.list_dog_name);
            textViewLocation = (TextView) itemView.findViewById(R.id.list_dog_location);

        }
    }


}
