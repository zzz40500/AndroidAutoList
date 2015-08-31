package com.mingle.autolist;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zzz40500 on 15/8/29.
 */
public class DataObserverHelper {


    private List<DataObserver> mDataObservers;
    private Fragment mFragment;


    public DataObserverHelper(Fragment fragment){
        mFragment = fragment;
        mDataObservers =new ArrayList<>();
    }
    public DataObserverHelper(Activity activity){
        mDataObservers =new ArrayList<>();

    }

    public  void add( DataObserver dataObserver){

        if(!mDataObservers.contains(dataObserver)) {
            mDataObservers.add(dataObserver);
        }

        if(mFragment == null ) {
            dataObserver.onRegister();
        }else if(mFragment .getView() != null){
            dataObserver.onRegister();
        }
    }



    public void register(){
        for (DataObserver item :mDataObservers){
            item.onRegister();
        }

    }

    public void unRegister(){
        for (DataObserver item :mDataObservers){
            item.onUnRegister();
        }

    }
}
