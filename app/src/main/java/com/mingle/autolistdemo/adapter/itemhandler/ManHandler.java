package com.mingle.autolistdemo.adapter.itemhandler;

import android.view.View;

import com.mingle.autolistdemo.R;
import com.mingle.autolistdemo.entity.ManEntity;
import com.mingle.autolistdemo.ui.ManDetailActivity;

import kale.adapter.handler.SimpleItemHandler;
import kale.adapter.util.ViewHolder;

/**
 * Created by zzz40500 on 15/8/30.
 */
public class ManHandler extends SimpleItemHandler<ManEntity> {


    @Override
    public int getLayoutResId() {
        return  R.layout.item_man;
    }


    @Override
    public void onBindView33(ViewHolder vh, ManEntity data, int position) {

        vh.setTextView(R.id.nameTV, data.name);
        vh.setTextView(R.id.ageTV, "年龄:".concat(data.age+""));
        vh.setTextView(R.id.heightTV, "身高:".concat(data.height));

        setOnClickListener(vh);
    }

    @Override
    public void onClick(View v, ManEntity manEntity, int position) {

        ManDetailActivity.startActivity(mContext, manEntity);
    }


}
