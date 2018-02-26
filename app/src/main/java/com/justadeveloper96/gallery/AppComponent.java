package com.justadeveloper96.gallery;

import com.justadeveloper96.gallery.list.MainActivity;
import com.justadeveloper96.helpers.Module.AppModule;
import com.justadeveloper96.helpers.Module.RetrofitModule;

import dagger.Component;

import javax.inject.Singleton;


@Singleton
@Component(modules = {AppModule.class, RetrofitModule.class})
public interface AppComponent {

    void inject(MainActivity app);
}
