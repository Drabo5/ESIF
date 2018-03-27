package com.esif.esif;

import android.app.Application;

import com.esif.esif.data.DataManager;
import com.esif.esif.data.di.component.ApplicationComponent;
import com.esif.esif.data.di.component.DaggerApplicationComponent;
import com.esif.esif.data.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by SAWADOGO Badini Ibrahim on 24,février,2018.
 */

public class MvpApp extends Application {

  @Inject
  DataManager mDataManager;

  private ApplicationComponent mApplicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mApplicationComponent = DaggerApplicationComponent.builder()
      .applicationModule(new ApplicationModule(this)).build();
    mApplicationComponent.inject(this);

  }

  public ApplicationComponent getComponent() {
    return mApplicationComponent;
  }


  // Needed to replace the component with a test specific one
  public void setComponent(ApplicationComponent applicationComponent) {
    mApplicationComponent = applicationComponent;
  }
}

