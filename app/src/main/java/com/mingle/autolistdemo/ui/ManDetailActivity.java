package com.mingle.autolistdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.mingle.autolist.AutoData;
import com.mingle.autolistdemo.R;
import com.mingle.autolistdemo.entity.ManEntity;

public class ManDetailActivity extends AppCompatActivity implements View.OnClickListener {



    private ManEntity mManEntity;

    private EditText mNameET, mAgeET, mHeightET;

    private boolean isAdd=false;

    public static  void startActivity(Context context, ManEntity manEntity){

        Intent intent=new Intent(context,ManDetailActivity.class);
        intent.putExtra("man", manEntity);
        context.startActivity(intent);

    }
    public static  void startActivity(Context context, int index){

        Intent intent=new Intent(context,ManDetailActivity.class);
        intent.putExtra("index", index);
        context.startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_detail);
        mNameET= (EditText) findViewById(R.id.nameET);
        mAgeET= (EditText) findViewById(R.id.ageET);
        mHeightET= (EditText) findViewById(R.id.heightET);
        handleIntent();
        initManEntity();
        initView();
        initListener();


    }

    private void initView() {

        if (isAdd){
            findViewById(R.id.toolLL).setVisibility(View.GONE);
        }else{
            findViewById(R.id.addBtn).setVisibility(View.GONE);
        }

    }

    private void initListener() {

        findViewById(R.id.addBtn).setOnClickListener(this);
        findViewById(R.id.deleteBtn).setOnClickListener(this);
        findViewById(R.id.upDateBtn).setOnClickListener(this);

    }

    private void initManEntity() {

        if(mManEntity != null) {
            mNameET.setText(mManEntity.name);
            mAgeET.setText(mManEntity.age+"");
            mHeightET.setText(mManEntity.height);
        }

    }

    private void handleIntent() {
       if( getIntent().hasExtra("man")){

           mManEntity=getIntent().getParcelableExtra("man");
       }else{
           isAdd=true;
           mManEntity=new ManEntity();
           mManEntity.id=getIntent().getIntExtra("index",33);
           mManEntity.name="new 王五"+ mManEntity.id;
           mManEntity.age=15;
           mManEntity.height="140cm";
       }

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case  R.id.addBtn:

                mManEntity.appleAction(this, AutoData.Action.Add).post();
                this.finish();
                break;
            case  R.id.deleteBtn:

                mManEntity.appleAction(this, AutoData.Action.Delete).post();

                this.finish();
                break;
            case  R.id.upDateBtn:
                mManEntity.name=mNameET.getText().toString();
                if(TextUtils.isEmpty(mAgeET.getText().toString())){
                    mManEntity.age =0;
                }else {
                    mManEntity.age = Integer.parseInt(mAgeET.getText().toString());
                }
                mManEntity.height=mHeightET.getText().toString();
                mManEntity.appleAction(this, AutoData.Action.Update).post();
                this.finish();
                break;
            default:
                break;
        }


    }
}
