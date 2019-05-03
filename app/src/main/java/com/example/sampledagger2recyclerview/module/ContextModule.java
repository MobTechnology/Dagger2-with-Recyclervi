package com.example.sampledagger2recyclerview.module;

import android.content.Context;

import com.example.sampledagger2recyclerview.qualifier.ApplicationContext;
import com.example.sampledagger2recyclerview.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule (Context context){this.context = context;}

    @Provides
    @ApplicationContext
    @ApplicationScope
    public Context provideContext(){return context;}

}
