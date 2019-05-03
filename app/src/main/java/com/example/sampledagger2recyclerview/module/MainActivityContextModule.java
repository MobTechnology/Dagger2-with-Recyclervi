package com.example.sampledagger2recyclerview.module;

import android.content.Context;

import com.example.sampledagger2recyclerview.MainActivity;
import com.example.sampledagger2recyclerview.qualifier.ActivityContext;
import com.example.sampledagger2recyclerview.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {

    private MainActivity mainActivity;
    public Context context;

    public MainActivityContextModule(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity(){
        return mainActivity;
  }

  @Provides
  @ActivityScope
  @ActivityContext
  public Context provideContext(){
        return context;
  }
}
