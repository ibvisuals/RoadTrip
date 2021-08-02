package com.example.roadtrip;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends Fragment {
    final private ArrayList<Destinations> destinations = new ArrayList<>();
    final private ArrayList<Destinations> cuisine = new ArrayList<>();
    final private ArrayList<Destinations> history = new ArrayList<>();
    private DestinationsAdapter destinationsAdapter;
    private DestinationsAdapter cuisineAdapter;
    private DestinationsAdapter historyAdapter;
    RecyclerView destinationsRecycler;
    RecyclerView cuisineRecycler;
    RecyclerView historyRecycler;
    private SharedViewModel model;

    FirebaseFirestore dataBase = FirebaseFirestore.getInstance();




    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {

        model = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        destinationsAdapter = new DestinationsAdapter(destinations, model);
        destinationsAdapter = new DestinationsAdapter(cuisine, model);
        destinationsAdapter = new DestinationsAdapter(history, model);

        RecyclerView destinationRecycler = view.findViewById(R.id.destinationrecyclerview);
        destinationRecycler.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        destinationRecycler.setAdapter(destinationsAdapter);

        RecyclerView cuisineRecycler = view.findViewById(R.id.cuisinerecyclerview);
        cuisineRecycler.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        cuisineRecycler.setAdapter(cuisineAdapter);

        RecyclerView historyRecycler = view.findViewById(R.id.historyrecyclerview);
        historyRecycler.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false));

        loadDataFromFireStore();
    }

    private void loadDataFromFireStore() {
        dataBase.collection("destinations").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot documents = task.getResult();
                    destinations.clear();
                    cuisine.clear();
                    history.clear();

                    for (QueryDocumentSnapshot document : documents) {
                        String docID = document.getId();
                        HashMap<String,Object> destinationMap = (HashMap<String, Object>) document.getData();
                        destinationMap.put("id", docID);


                    }
                }

            }
        });
    }

}