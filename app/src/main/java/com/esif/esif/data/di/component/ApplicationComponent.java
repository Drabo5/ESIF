package com.esif.esif.data.di.component;

import android.app.Application;

import com.esif.esif.MvpApp;
import com.esif.esif.data.DataManager;
import com.esif.esif.data.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by SAWADOGO Badini Ibrahim on 27,mars,2018.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

  void inject(MvpApp app);
  Application application();

  DataManager getDataManager();

}
