package com.mingle.autolistdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.mingle.autolist.AutoList;
import com.mingle.autolistdemo.R;
import com.mingle.autolistdemo.adapter.ManAdapter;
import com.mingle.autolistdemo.entity.ManEntity;


public class MansActivity extends AppCompatActivity {


    private AutoList<ManEntity> mAutoList=new AutoList<>(ManEntity.class);


    private BaseAdapter adapter;
    private  int mIndex=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mans);

        initData();
        adapter=new ManAdapter(this,mAutoList);
        ListView lv= (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);

    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            ManEntity manEntity =new ManEntity();
            manEntity.id=i;
            manEntity.name="王五 "+i;
            manEntity.height="140cm";
            manEntity.age=15;
            mAutoList.add(manEntity);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mans, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.addMan) {
            ManDetailActivity.startActivity(this,mIndex++);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
