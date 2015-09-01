package com.mingle.autolistdemo.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.mingle.autolistdemo.adapter.itemhandler.ManHandler;
import java.util.HashMap;
import java.util.List;
import kale.adapter.adapter.AutoAdapter;
import kale.adapter.handler.ItemHandler;

/**
 * Created by zzz40500 on 15/8/30.
 */
public class ManAdapter extends AutoAdapter {
    public ManAdapter(Activity activity, List<?> data) {
        super(activity, data);
    }

    protected ManAdapter(Fragment fragment, List<?> data) {
        super(fragment, data);
    }

    @Override
    protected void initHandlers(HashMap<Integer, ItemHandler> itemHandlerHashMap) {

        addHandler(0,new ManHandler());
    }

    @Override
    protected int getViewType(int position) {
        return 0;
    }
}
