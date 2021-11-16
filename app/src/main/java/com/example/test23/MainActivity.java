package com.example.test23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {



    RecyclerView recyclerView;
    List<DataModel> chatList;
    Adaptery.RecyclerViewClickListerner listerner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=findViewById(R.id.rcylid);
        chatList=new ArrayList<>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instances for interface
        MyAPICall myAPICall = retrofit.create(MyAPICall.class);

        Call<JSONResponse> call=myAPICall.getData();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                chatList = new ArrayList<>(Arrays.asList(jsonResponse.getResults()));

                PutDataIntoRecyclerView(chatList);

            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });



    }

    private void PutDataIntoRecyclerView(List<DataModel> chatList) {
        setOnClickListener();

        Adaptery adaptery = new Adaptery(this,chatList,listerner);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);
    }

    private void setOnClickListener() {
        listerner = new Adaptery.RecyclerViewClickListerner() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
                intent.putExtra("thumbnail",chatList.get(position).getcPicture().getThumbnail());
                startActivity(intent);
            }
        };
    }
}