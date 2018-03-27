package com.esif.esif.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.esif.esif.data.di.ApplicationContext;
import com.esif.esif.data.di.PreferenceInfo;

import javax.inject.Inject;

/**
 * Created by SAWADOGO Badini Ibrahim on 27,mars,2018.
 * Cette classe permte de sauvegarde les preferencesl'ulisateur
 */

public class AppPreferencesHelper implements PreferencesHelper {

  private SharedPreferences mPreferences;
  private SharedPreferences.Editor editor;


  @Inject
  public AppPreferencesHelper(@ApplicationContext Context context,
                              @PreferenceInfo String prefFileName) {
    mPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
  }
}
