package com.example.sampledagger2recyclerview.adapter;

import com.example.sampledagger2recyclerview.MainActivity;
import com.example.sampledagger2recyclerview.module.MainActivityContextModule;
import com.example.sampledagger2recyclerview.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getUserData(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }
}
