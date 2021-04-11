package com.example.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mysql.model.loginModel.User;
import com.example.mysql.retrofit.GetApi;
import com.example.mysql.retrofit.RetrofitC;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPage extends AppCompatActivity {
    Button register;
    EditText name;
    EditText pass;
    Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        register = findViewById(R.id.button2);
        name = findViewById(R.id.edit2);
        pass = findViewById(R.id.edit3);
        go = findViewById(R.id.button);
    }

    public void register(View view) {
        String getName = name.getText().toString();
        String getPass = pass.getText().toString();
        Call<User> call = RetrofitC.retrofitI().create(GetApi.class).userRegister(getName, getPass);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    System.out.println(response.body().getResult_code());
                    Toast.makeText(RegisterPage.this,"ok",Toast.LENGTH_SHORT).show();

                } else {
                    System.out.println("hata");

                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t.toString());


            }
        });
    }
    public void goLogin (View v){
        Intent intent = new Intent(RegisterPage.this,LoginPage.class);
        startActivity(intent);

    }
}