package com.example.sampledagger2recyclerview.component;

import com.example.sampledagger2recyclerview.MainActivity;
import com.example.sampledagger2recyclerview.adapter.AdapterModule;
import com.example.sampledagger2recyclerview.scopes.ActivityScope;
import dagger.Component;


@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
 public void injectMainActivity(MainActivity mainActivity);
}
