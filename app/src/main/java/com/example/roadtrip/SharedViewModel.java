package com.example.roadtrip;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Destinations> selected =new MutableLiveData<>();

    public void select(Destinations item) {selected.setValue(item);}

    public LiveData<Destinations> getSelected() {return selected;}

}
