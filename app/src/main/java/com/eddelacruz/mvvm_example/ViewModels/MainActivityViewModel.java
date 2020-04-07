package com.eddelacruz.mvvm_example.ViewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;


import com.eddelacruz.mvvm_example.Models.FBPlayer;
import com.eddelacruz.mvvm_example.Repositories.FBPlayerRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<FBPlayer>> mFBPlayers;
    private FBPlayerRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(){
        if(mFBPlayers != null){
            return;
        }
        mRepo = FBPlayerRepository.getInstance();
        mFBPlayers = mRepo.getFBPlayers();
    }

    public void addNewValue(final FBPlayer FBPlayer){
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<FBPlayer> currentPlaces = mFBPlayers.getValue();
                currentPlaces.add(FBPlayer);
                mFBPlayers.postValue(currentPlaces);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<FBPlayer>> getFBPlayers(){
        return mFBPlayers;
    }


    public LiveData<Boolean> getIsUpdating(){
        return mIsUpdating;
    }
}
