package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mysql.model.loginModel.User;
import com.example.mysql.retrofit.GetApi;
import com.example.mysql.retrofit.RetrofitC;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginPage extends AppCompatActivity {
    EditText name;
    EditText pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.button2);
        name = findViewById(R.id.edit2);
        pass = findViewById(R.id.edit3);

    }

    public void login(View v){
        String gname=name.getText().toString();
        String gpass=pass.getText().toString();
        Call<User> call= RetrofitC.retrofitI().create(GetApi.class).userLogin(gname,gpass);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.code()==200){
                    System.out.println(response.body().getName());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t.getLocalizedMessage());
                System.out.println(t.hashCode());
            }
        });






    }
}