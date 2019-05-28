package com.example.prit.silverlabsdemoapp.internet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("/v2/5ced816a3200005f000c131b")
    public Call<List<ApiObject>> getAllPost();

}
