package com.example.prit.silverlabsdemoapp.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.widget.Toast;

import com.example.prit.silverlabsdemoapp.BR;
import com.example.prit.silverlabsdemoapp.adapter.DataAdapter;
import com.example.prit.silverlabsdemoapp.internet.ApiObject;
import com.example.prit.silverlabsdemoapp.internet.ApiUtil;
import com.example.prit.silverlabsdemoapp.model.DataModel;
import com.example.prit.silverlabsdemoapp.presenter.SortInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends BaseObservable implements SortInterface{
    private DataAdapter adapter;
    private List<DataModel> data;
    private List<ApiObject> apiObjects;
    public MutableLiveData<DataModel> selected;

    public DataViewModel() {
        data = new ArrayList<>();
        adapter = new DataAdapter();
        selected = new MutableLiveData<>();
    }

    public void setUp() {
        if(data == null || data.size() == 0)
            populateData();
    }

    public MutableLiveData<DataModel> getSelected() {
        return selected;
    }

    public void onItemClick(Integer index) {
        Log.d("PRIT", "CLICKED " + index);
        DataModel db = getItemAt(index);
        selected.setValue(db);
    }

    public DataModel getItemAt(Integer index) {
        if (index != null) {
            return data.get(index);
        }
        return null;
    }

    @Bindable
    public List<DataModel> getData() {
        return this.data;
    }

    @Bindable
    public DataAdapter getAdapter() {
        return this.adapter;
    }

    private void populateData() {
        // populate the data from the source, such as the database.
        ApiUtil.getServiceClass().getAllPost().enqueue(new Callback<List<ApiObject>>() {
            @Override
            public void onResponse(Call<List<ApiObject>> call, Response<List<ApiObject>> response) {
                if (response.isSuccessful()) {
                    //progressDialog.dismiss();
                    apiObjects = response.body();
                    Log.d("retro", "Returned count " + apiObjects.size());
                    addDataToAdapter();
                    //addSortedDataToAdapter();
                }
            }

            @Override
            public void onFailure(Call<List<ApiObject>> call, Throwable t) {
                Log.d("retro", "error loading from API ::::" + t.getLocalizedMessage() + " :::: " + t.getMessage() + " :::: " + t.getCause());
            }
        });

    }

    private void addDataToAdapter() {
        for (int i = 0; i < apiObjects.size(); i++) {
            DataModel dataModel = new DataModel();
            dataModel.setName(apiObjects.get(i).getName());
            dataModel.setUrl(apiObjects.get(i).getPhoto());
            dataModel.setHeight(apiObjects.get(i).getHeight());
            dataModel.setAge(apiObjects.get(i).getAge());
            dataModel.setPopularity(apiObjects.get(i).getPopularity());
            data.add(dataModel);
        }
        notifyPropertyChanged(BR.data);
    }

    Comparator<DataModel> AgeComparator = new Comparator<DataModel>() {
        @Override
        public int compare(DataModel dm1, DataModel dm2) {
            return Integer.parseInt(dm1.getAge()) > Integer.parseInt(dm2.getAge()) ? -1 : 1;
        }
    };

    Comparator<DataModel> HeightComparator = new Comparator<DataModel>() {
        @Override
        public int compare(DataModel dm1, DataModel dm2) {
            return Integer.parseInt(dm1.getHeight()) > Integer.parseInt(dm2.getHeight()) ? -1 : 1;
        }
    };

    Comparator<DataModel> PopularityComparator = new Comparator<DataModel>() {
        @Override
        public int compare(DataModel dm1, DataModel dm2) {
            return Integer.parseInt(dm1.getPopularity()) > Integer.parseInt(dm2.getPopularity()) ? -1 : 1;
        }
    };

    @Override
    public void sort(int sort_according) {
        switch (sort_according) {
            case SORT_AGE:
                Collections.sort(data, AgeComparator);
                break;
            case SORT_HEIGHT:
                Collections.sort(data, HeightComparator);
                break;
            case SORT_POPULARITY:
                Collections.sort(data, PopularityComparator);
                break;
        }
        notifyPropertyChanged(BR.data);
    }

    public SortInterface getInterfaceInstance() {
        return this;
    }
}
