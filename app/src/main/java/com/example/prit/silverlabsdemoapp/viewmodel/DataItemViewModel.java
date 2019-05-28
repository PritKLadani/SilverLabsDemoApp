package com.example.prit.silverlabsdemoapp.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.example.prit.silverlabsdemoapp.model.DataModel;

public class DataItemViewModel extends BaseObservable {
    private DataModel dataModel;

    public DataItemViewModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public void setUp() {

    }

    @Bindable
    public String getName() {
        return !TextUtils.isEmpty(dataModel.getName()) ? dataModel.getName() : "";
    }

    @Bindable
    public String getUrl() {
        return !TextUtils.isEmpty(dataModel.getUrl()) ? dataModel.getUrl() : "";
    }

    @Bindable
    public String getAge() {
        return !TextUtils.isEmpty(dataModel.getAge()) ? dataModel.getAge() : "";
    }

    @Bindable
    public String getPopularity() {
        return !TextUtils.isEmpty(dataModel.getPopularity()) ? dataModel.getPopularity() : "";
    }

    @Bindable
    public String getHeight() {
        return !TextUtils.isEmpty(dataModel.getHeight()) ? dataModel.getHeight() : "";
    }
}
