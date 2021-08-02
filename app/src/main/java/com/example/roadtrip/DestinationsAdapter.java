package com.example.roadtrip;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class DestinationsAdapter extends RecyclerView.Adapter<DestinationsAdapter.DestinationsHolder> {

    ArrayList<Destinations> mDestinations;
    private SharedViewModel model;

    public DestinationsAdapter(ArrayList <Destinations> destinations, SharedViewModel model) {
        mDestinations = destinations;
        this.model = model;
    }


    @NonNull
    @Override
    public DestinationsAdapter.DestinationsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.destinations_item, parent, false);
        return new DestinationsAdapter.DestinationsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationsAdapter.DestinationsHolder holder, int position) {
        Destinations destinations = mDestinations.get(position);
        holder.mName.setText(destinations.getName());
        holder.mItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.select(destinations);
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_destinationsDetailsFragment);

            }
        });



    }

    @Override
    public int getItemCount() { return mDestinations.size(); }


    static class DestinationsHolder extends RecyclerView.ViewHolder {
        TextView mName;
        ImageView mPoster;
        ConstraintLayout mItem;

        public DestinationsHolder(View view) {
            super(view);
            mName = view.findViewById(R.id.destinations_item_name);
            mPoster = view.findViewById(R.id.destinations_item_image);
            mItem = view.findViewById(R.id.destinations_item);
        }
    }
}
