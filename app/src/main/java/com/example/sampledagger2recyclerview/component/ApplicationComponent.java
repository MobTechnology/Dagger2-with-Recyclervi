package com.example.sampledagger2recyclerview.component;

import android.app.Application;
import android.content.Context;

import com.example.sampledagger2recyclerview.module.ContextModule;
import com.example.sampledagger2recyclerview.network.IApis;
import com.example.sampledagger2recyclerview.network.PicassoModule;
import com.example.sampledagger2recyclerview.network.RetrofitModel;
import com.example.sampledagger2recyclerview.qualifier.ApplicationContext;
import com.example.sampledagger2recyclerview.scopes.ApplicationScope;
import com.squareup.picasso.Picasso;
import dagger.Component;

@ApplicationScope
@Component(modules = {RetrofitModel.class,  PicassoModule.class})
public interface ApplicationComponent {

    public IApis getApisInterface();

    Picasso getPicasso();

    @ApplicationContext
    Context getContext();

    public void applicationInject(Application application);
}
