package com.example.prit.silverlabsdemoapp.presenter;

public interface SortInterface {

    int SORT_AGE = 0;
    int SORT_HEIGHT = 1;
    int SORT_POPULARITY = 2;

    void sort(int sort_according);
}
