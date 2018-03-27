package com.esif.esif.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by SAWADOGO Badini Ibrahim on 24,février,2018.
 */

public interface MvpView {

  /**
   *
   */
  void showLoading();

  /**
   *
   */
  void hideLoading();

  /**
   *
   * @param resId
   */
  void onError(@StringRes int resId);

  /**
   *
   * @param message
   */
  void onError(String message);

  /**
   *
   * @param message
   */
  void showMessage(String message);

  /**
   *
   * @param resId
   */
  void showMessage(@StringRes int resId);

  /**
   *
   * @return
   */
  boolean isNetworkConnected();
}
