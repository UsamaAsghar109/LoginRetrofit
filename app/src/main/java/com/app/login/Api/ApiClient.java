package com.app.login.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient{

    public static final String BASE_URL="http://52.77.17.12/comGpsGate/api/v.1/applications/16/";
    public static final String TOKEN="tokens";
    public static final String USER_STATUS = "users/403/status";

//    ApiClient instance= new ApiClient();

    public static Retrofit getretrofit() {


        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static ApiServices getApiServices() {
        ApiServices apiServices = getretrofit().create(ApiServices.class);
        return apiServices;
    }

}