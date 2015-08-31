package com.mingle;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.mingle.autolist.DataObserver;
import com.mingle.autolist.DataObserverEnable;
import com.mingle.autolist.DataObserverHelper;


public class AutoListFragment extends Fragment implements DataObserverEnable {
    DataObserverHelper mDataObserverHelper =new DataObserverHelper(this);
    public AutoListFragment() {
    }
    @Override
    public void addDataObserver(DataObserver dataObserver) {
        mDataObserverHelper.add(dataObserver);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDataObserverHelper.register();
    }
    @Override
    public void onDestroyView() {
        mDataObserverHelper.unRegister();
        super.onDestroyView();
    }

}
