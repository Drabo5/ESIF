package com.esif.esif.main;

import com.esif.esif.data.DataManager;
import com.esif.esif.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by SAWADOGO Badini Ibrahim on 27,mars,2018.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V>{


  @Inject
  public MainPresenter(DataManager dataManager) {
    super(dataManager);
  }
}
