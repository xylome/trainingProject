package com.orange.devoxx.view;

import android.util.Log;

/**
 * Created by xylome on 25/04/2016.
 */
public abstract class BasePresenter<V> {

    protected final V view;

    public BasePresenter(V view) {
        this.view = view;
        Log.d("BasePresenter", "View hold is:" + view.getClass().getSimpleName());
    }

}
