package com.example.dangineering.myapplication.network.retrofit;


import android.util.Log;

import com.example.dangineering.myapplication.data.model.ImageModel;
import com.example.dangineering.myapplication.data.repository.ImageRepository;
import com.example.dangineering.myapplication.network.responsemodel.DisplaySize;
import com.example.dangineering.myapplication.network.responsemodel.GettyResponseModel;
import com.example.dangineering.myapplication.network.responsemodel.Image;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/** sample pojo for di testing */
public class GettyApiRepository implements ImageRepository {

    Retrofit retrofit;
    GettyApiService gettyApiService;

    public GettyApiRepository(Retrofit retrofit) {
        this.retrofit = retrofit;
        gettyApiService = retrofit.create(GettyApiService.class);
    }

    public GettyApiRepository() {


        OkHttpClient okhttp = new OkHttpClient().newBuilder()
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder().addHeader("Api-Key", "api-key").build();
                        return chain.proceed(request);
                    }
                })
                .build();

        //gson
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();


        // create retrofit object with intercepter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.gettyimages.com/")
                .client(okhttp)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // create service
        gettyApiService = retrofit.create(GettyApiService.class);
    }

    @Override
    public List<ImageModel> getImageModels(String query) {
        Call<GettyResponseModel> gettyResponseModel = gettyApiService.getImages(query);
        List<Image> result = new ArrayList<>();
        // sync
        try {
            GettyResponseModel get = gettyResponseModel.execute().body();
            result.addAll(get.getImages());

        } catch (IOException e) {
            e.printStackTrace();
        }

//        // async
//        gettyResponseModel.enqueue(new Callback<GettyResponseModel>() {
//            @Override
//            public void onResponse(Call<GettyResponseModel> call, retrofit2.Response<GettyResponseModel> response) {
//                Log.d("call", response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<GettyResponseModel> call, Throwable t) {
//                Log.d("error", t.getMessage());
//            }
//        });

        return convertToImageModel(result);
    }

    private List<ImageModel> convertToImageModel(List<Image> images) {
        List<ImageModel> im = new ArrayList<>();
        for (Image image : images) {
            // TODO: fix
            //String uri = image.getDisplaySizes().get(0).getUri();
            String uri = "";
            List<DisplaySize> ds = image.getDisplaySizes();
            if (!ds.isEmpty()) {
                uri = ds.get(0).getUri();
            }
            String desc = image.getCaption();

            im.add(new ImageModel(uri, desc));

        }
        return im;
    }
}
