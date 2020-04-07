package com.eddelacruz.mvvm_example;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.eddelacruz.mvvm_example.Adapters.RecyclerAdapter;
import com.eddelacruz.mvvm_example.Models.FBPlayer;
import com.eddelacruz.mvvm_example.ViewModels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private ProgressBar mProgressBar;
    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFab = findViewById(R.id.fab);
        mRecyclerView = findViewById(R.id.recycler_view);
        mProgressBar = findViewById(R.id.progress_bar);

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        mMainActivityViewModel.init();

        mMainActivityViewModel.getFBPlayers().observe(this, new Observer<List<FBPlayer>>() {
            @Override
            public void onChanged(@Nullable List<FBPlayer> FBPlayers) {
                mAdapter.notifyDataSetChanged();
            }
        });

        mMainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }
                else{
                    hideProgressBar();
                    mRecyclerView.smoothScrollToPosition(mMainActivityViewModel.getFBPlayers().getValue().size()-1);
                }
            }
        });


        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Randin = generateRandomInt();
                FBPlayer addFB = generateData(Randin);

                mMainActivityViewModel.addNewValue(
                        new FBPlayer(
                                addFB.getImageUrl(), addFB.getTitle()
                        )
                );
            }
        });

        initRecyclerView();
    }


    private void initRecyclerView(){
        mAdapter = new RecyclerAdapter(this, mMainActivityViewModel.getFBPlayers().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }

    private int generateRandomInt() {
        Random rn = new Random();
        int Randin = rn.nextInt(10) + 1;
        return Randin;
    }

    private FBPlayer generateData(int myint) {
        FBPlayer fbp = new FBPlayer();

        switch(myint) {
            case 0:
                fbp.setImageUrl("https://tse2.mm.bing.net/th?id=OIP.1C7nXX35S7fuVY0RtJsi_QAAAA&pid=Api&P=0&w=260&h=173");
                fbp.setTitle("Sadio Mane");
                break;
            case 1:
                fbp.setImageUrl("https://resources.premierleague.com/photos/2019/04/11/5501337c-23af-412e-adcb-178e0d81119f/Vardy.jpg?width=939&height=620");
                fbp.setTitle("Jamie Vardy");
                break;
            case 2:
                fbp.setImageUrl("https://tse2.mm.bing.net/th?id=OIP.rihUvlPVYd00fA8npJbJpAHaE8&pid=Api&P=0&w=260&h=174");
                fbp.setTitle("Marcus Rashford");
                break;
            case 3:
                fbp.setImageUrl("https://tse1.mm.bing.net/th?id=OIP.UVtof83jNLuRm_Fj2TJHewHaHa&pid=Api&P=0&w=300&h=300");
                fbp.setTitle("Anthony Martial");
                break;
            case 4:
                fbp.setImageUrl("https://static.independent.co.uk/s3fs-public/thumbnails/image/2018/03/20/13/mohamed-salah.jpg");
                fbp.setTitle("Mo Salah");
                break;
            case 5:
                fbp.setImageUrl("https://images.performgroup.com/di/library/GOAL/42/6/martin-odegaard-vitesse-2018-19_1onwbtz26wnp71kzimgz6kmi2o.jpg?t=620434313&quality=100");
                fbp.setTitle("Martin Odegaard");
                break;
            case 6:
                fbp.setImageUrl("https://tse3.mm.bing.net/th?id=OIP.gJ4sCQ5zqDh_NtKH31IDKwHaFF&pid=Api&P=0&w=240&h=166");
                fbp.setTitle("Eden Hazard");
                break;
            case 7:
                fbp.setImageUrl("https://tse1.mm.bing.net/th?id=OIP.cFfU1cOiSXN4LgNtVzsLEQHaD4&pid=Api&P=0&w=305&h=161");
                fbp.setTitle("Raheem Sterling");
                break;
            default:
                fbp.setImageUrl("https://i.dailymail.co.uk/1s/2019/02/16/20/9902742-0-image-m-4_1550347332881.jpg");
                fbp.setTitle("Adam troure");
                break;
        }
        return fbp;
    }
}




















