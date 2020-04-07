package com.eddelacruz.mvvm_example.Repositories;

import android.arch.lifecycle.MutableLiveData;


import com.eddelacruz.mvvm_example.Models.FBPlayer;

import java.util.ArrayList;
import java.util.List;


/**
 * Singleton pattern
 */
public class FBPlayerRepository {

    private static FBPlayerRepository instance;
    private ArrayList<FBPlayer> dataSet = new ArrayList<>();

    public static FBPlayerRepository getInstance(){
        if(instance == null){
            instance = new FBPlayerRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<FBPlayer>> getFBPlayers(){
        setFBPlayers();
        MutableLiveData<List<FBPlayer>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setFBPlayers(){
        dataSet.add(
                new FBPlayer("https://i.ytimg.com/vi/CsNoX5zPv6M/maxresdefault.jpg",
                        "Cristiano Ronaldo")
        );
        dataSet.add(
                new FBPlayer("https://tse2.mm.bing.net/th?id=OIP.IwzCCy5hGSy2jFa7PhQ-FAHaFj&pid=Api&P=0&w=248&h=187",
                        "Lionel Messi")
        );
        dataSet.add(
                new FBPlayer("https://i0.wp.com/metro.co.uk/wp-content/uploads/2019/12/GettyImages-1185806382.jpg?quality=90&strip=all&zoom=1&resize=644%2C429&ssl=1",
                        "Erling Haaland")
        );
        dataSet.add(
                new FBPlayer("https://images.performgroup.com/di/library/omnisport/ca/a5/mbappecropped_amabncwglz8i1v2o9z0dml5cv.jpg?t=124441275&quality=100",
                        "Kylian Mbappe")
        );
        dataSet.add(
                new FBPlayer("https://cdn.images.dailystar.co.uk/dynamic/58/photos/6000/620x/Robert-Lewandowski-694490.jpg",
                        "Robert Lewandowski")
        );
        dataSet.add(
                new FBPlayer("https://tse2.mm.bing.net/th?id=OIP.Rv6Lo52tiAI6NSHQrs04eAHaEK&pid=Api&P=0&w=305&h=172",
                        "Neymar Jr.")
        );
        dataSet.add(
                new FBPlayer("https://tse1.mm.bing.net/th?id=OIP.DfcqL4RIKvDVQh15IPo6wwHaFX&pid=Api&P=0&w=239&h=174",
                        "Sergio Aguero")
        );
        dataSet.add(
                new FBPlayer("https://tse3.mm.bing.net/th?id=OIP.yejS8-G2CGekBBHDLgkpuQHaEK&pid=Api&P=0&w=315&h=178",
                        "Harry Kane")
        );
    }
}











