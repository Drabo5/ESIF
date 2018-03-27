package com.esif.esif.data.di.module;

import android.app.Application;
import android.content.Context;

import com.esif.esif.data.AppDataManager;
import com.esif.esif.data.DataManager;
import com.esif.esif.data.di.ApplicationContext;
import com.esif.esif.data.di.PreferenceInfo;
import com.esif.esif.data.prefs.AppPreferencesHelper;
import com.esif.esif.data.prefs.PreferencesHelper;
import com.esif.esif.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by SAWADOGO Badini Ibrahim on 27,mars,2018.
 */

@Module
public class ApplicationModule {
  private final Application mApplication;

  public ApplicationModule(Application application) {
    mApplication = application;
  }

  @Provides
  @ApplicationContext
  Context provideContext() {
    return mApplication;
  }

  @Provides
  Application provideApplication() {
    return mApplication;
  }


  @Provides
  @Singleton
  DataManager provideDataManager(AppDataManager appDataManager) {
    return appDataManager;
  }

  @Provides
  @Singleton
  PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
    return appPreferencesHelper;
  }

  @Provides
  @PreferenceInfo
  String providePreferenceName() {
    return AppConstants.PREF_NAME;
  }
}
