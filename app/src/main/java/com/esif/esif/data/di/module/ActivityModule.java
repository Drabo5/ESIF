package com.esif.esif.data.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.esif.esif.data.di.ActivityContext;
import com.esif.esif.data.di.PerActivity;
import com.esif.esif.main.MainMvpPresenter;
import com.esif.esif.main.MainMvpView;
import com.esif.esif.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by SAWADOGO Badini Ibrahim on 27,mars,2018.
 */

@Module
public class ActivityModule {

  private AppCompatActivity mActivity;

  public ActivityModule(AppCompatActivity activity) {
    this.mActivity = activity;
  }

  @Provides
  @ActivityContext
  Context provideContext() {
    return mActivity;
  }

  @Provides
  AppCompatActivity provideActivity() {
    return mActivity;
  }


  @Provides
  @PerActivity
  MainMvpPresenter<MainMvpView>
  provideMainPresenter(MainPresenter<MainMvpView> presenter){
    return presenter;
  }
}
