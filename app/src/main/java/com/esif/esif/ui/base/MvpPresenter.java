package com.esif.esif.ui.base;

/**
 * Created by SAWADOGO Badini Ibrahim on 24,février,2018.
 */

public interface MvpPresenter<V extends MvpView> {

  void onAttach(V mvpView);
  void onDetach();
}
