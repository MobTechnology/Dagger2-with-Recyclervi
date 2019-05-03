package com.example.sampledagger2recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sampledagger2recyclerview.adapter.RecyclerViewAdapter;
import com.example.sampledagger2recyclerview.component.ApplicationComponent;

import com.example.sampledagger2recyclerview.component.DaggerMainActivityComponent;
import com.example.sampledagger2recyclerview.component.MainActivityComponent;
import com.example.sampledagger2recyclerview.module.MainActivityContextModule;
import com.example.sampledagger2recyclerview.network.IApis;
import com.example.sampledagger2recyclerview.pojo.Data;
import com.example.sampledagger2recyclerview.pojo.UserData;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickListener{

    private RecyclerView recyclerView;


    MainActivityComponent component;

    Picasso picasso;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    public IApis apis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recylicView);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDividerItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ApplicationComponent applicationComponent = AppApplication.get(this).getApplicationComponent();

        component = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent).build();

        picasso = applicationComponent.getPicasso();

        component.injectMainActivity(this);
        recyclerView.setAdapter(recyclerViewAdapter);

        apis.getUserData().enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                Log.d("TAG", "Response-->"+response.body().getData());
                populateRecyclerView(response.body().getData());
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {

            }
        });

    }

    private void populateRecyclerView(List<Data> data) {
        recyclerViewAdapter.setData(data);
    }

    @Override
    public void launchIntent(String filmName) {

    }
}
