package com.esif.esif.data;

import android.content.Context;

import com.esif.esif.data.di.ApplicationContext;
import com.esif.esif.data.prefs.PreferencesHelper;

import javax.inject.Inject;

/**
 * Created by SAWADOGO Badini Ibrahim on 27,mars,2018.
 */

public class AppDataManager implements DataManager {

  private  Context mContext;
  private  PreferencesHelper mPreferencesHelper;


  @Inject
  public AppDataManager(@ApplicationContext Context context, PreferencesHelper preferencesHelper) {
    mContext = context;
    mPreferencesHelper = preferencesHelper;
  }
}
