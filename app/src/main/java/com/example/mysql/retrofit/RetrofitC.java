package com.example.mysql.retrofit;

import com.example.mysql.model.loginModel.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitC {
    public static final String BASE_URL = "http://192.168.1.108/employeedb/";
    static private Retrofit retrofit = null;
    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit retrofitI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))//Use Gson
                .build();
        return retrofit;
    }

}
