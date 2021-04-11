package com.example.mysql.retrofit;

import com.example.mysql.model.loginModel.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetApi {
    @FormUrlEncoded
    @POST("register.php")
    Call<User> userRegister(@Field("name") String name, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("login.php")
    Call<User> userLogin(@Field("name") String name, @Field("pass") String pass);

}
