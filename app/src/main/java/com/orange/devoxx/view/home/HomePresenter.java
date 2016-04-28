package com.orange.devoxx.view.home;

import com.orange.devoxx.view.BaseActivityPresenter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xylome on 25/04/2016.
 */
public class HomePresenter extends BaseActivityPresenter<HomeView> {



    protected HomePresenter(HomeView view) {
        super(view);
    }

    public void onButtonClicked(String foo) {
        String enriched = "enriched from presenter + " + foo;
        view.displayLog(enriched);
    }

}
