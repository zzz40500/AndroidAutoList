package com.mingle.autolistdemo.adapter;
import android.app.Activity;
import android.support.v4.app.Fragment;
import com.mingle.autolistdemo.adapter.itemhandler.ManHandler;
import java.util.HashMap;
import java.util.List;
import kale.adapter.adapter.AutoRVAdapter;
import kale.adapter.handler.ItemHandler;

/**
 * Created by zzz40500 on 15/8/30.
 */
public class ManRVAdapter extends AutoRVAdapter {
    public ManRVAdapter(Activity activity, List<?> data) {
        super(activity, data);
    }

    public ManRVAdapter(Fragment fragment, List<?> data) {
        super(fragment, data);
    }

    @Override
    protected void initHandlers(HashMap<Integer, ItemHandler> itemHandlerHashMap) {
        addHandler(0, new ManHandler());
    }

    @Override
    protected int getViewType(int position) {
        return 0;
    }
}
