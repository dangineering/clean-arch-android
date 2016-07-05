package com.example.dangineering.myapplication.network.retrofit;

import com.example.dangineering.myapplication.network.responsemodel.GettyResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GettyApiService {

    @GET("v3/search/images")
    Call<GettyResponseModel> getImages(@Query("phrase") String query);
}
