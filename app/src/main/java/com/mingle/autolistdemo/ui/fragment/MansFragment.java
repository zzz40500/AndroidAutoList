package com.mingle.autolistdemo.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mingle.AutoDataFragment;
import com.mingle.autolist.AutoList;
import com.mingle.autolistdemo.R;
import com.mingle.autolistdemo.adapter.ManRVAdapter;
import com.mingle.autolistdemo.entity.ManEntity;
import com.mingle.autolistdemo.ui.ManDetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MansFragment extends AutoDataFragment {


    private AutoList<ManEntity> mAutoList=new AutoList<ManEntity>(ManEntity.class);
    private  int mIndex=20;

    public MansFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View  view=inflater.inflate(R.layout.fragment_man, container, false);
        for (int i = 0; i < 20; i++) {

            ManEntity manEntity =new ManEntity();
            manEntity.id=i;
            manEntity.name="王五 "+i;
            manEntity.height="140cm";
            manEntity.age=15;
            mAutoList.add(manEntity);
        }
        ManRVAdapter  adapter=new ManRVAdapter(this,mAutoList);
        RecyclerView rv= (RecyclerView) view.findViewById(R.id.rv);
        setHasOptionsMenu(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.addMan) {
            ManDetailActivity.startActivity(getActivity(), mIndex++);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
