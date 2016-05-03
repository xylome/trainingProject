package com.orange.devoxx.view.home;

/**
 * Created by xylome on 25/04/2016.
 */
public interface HomeView {

    void updateFabButton(boolean isSelected, boolean animate);

    void displayLog(String foo);

    void backToLogin();

    void displayNick(String nick);
}
