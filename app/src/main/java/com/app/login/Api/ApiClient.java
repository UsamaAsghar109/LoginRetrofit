package com.app.login.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient{

//    ApiClient instance= new ApiClient();

    public static Retrofit getretrofit() {


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://52.77.17.12/comGpsGate/api/v.1/applications/16/")
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static ApiServices getApiServices() {
        ApiServices apiServices = getretrofit().create(ApiServices.class);
        return apiServices;
    }

}