package com.esif.esif.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.esif.esif.MvpApp;
import com.esif.esif.R;
import com.esif.esif.data.di.component.ActivityComponent;
import com.esif.esif.data.di.component.DaggerActivityComponent;
import com.esif.esif.data.di.module.ActivityModule;
import com.esif.esif.utils.CommonUtils;
import com.esif.esif.utils.NetworkUtils;

/**
 * Created by SAWADOGO Badini Ibrahim on 24,février,2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements MvpView{

  private ProgressDialog mProgressDialog;
  private ActivityComponent mActivityComponent;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mActivityComponent = DaggerActivityComponent.builder()
      .activityModule(new ActivityModule(this))
      .applicationComponent(((MvpApp) getApplication()).getComponent())
      .build();

  }

  public ActivityComponent getActivityComponent() {
    return mActivityComponent;
  }

  @TargetApi(Build.VERSION_CODES.M)
  public void requestPermissionsSafely(String[] permissions, int requestCode) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      requestPermissions(permissions, requestCode);
    }
  }

  @TargetApi(Build.VERSION_CODES.M)
  public boolean hasPermission(String permission) {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
      checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
  }

  @Override
  public void showLoading() {
    hideLoading();
    mProgressDialog = CommonUtils.showLoadingDialog(this);
  }

  @Override
  public void hideLoading() {
    if (mProgressDialog != null && mProgressDialog.isShowing()) {
      mProgressDialog.cancel();
    }
  }

  private void showSnackBar(String message) {
    Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
    View sbView = snackbar.getView();
    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
    textView.setTextColor(ContextCompat.getColor(this, R.color.white));
    snackbar.show();
  }

  @Override
  public void onError(String message) {
    if (message != null) {
      showSnackBar(message);
    } else {
      showSnackBar(getString(R.string.some_error));
    }
  }

  @Override
  public void onError(@StringRes int resId) {
    onError(getString(resId));
  }

  @Override
  public void showMessage(String message) {
    if (message != null) {
      Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    } else {
      Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_LONG).show();
    }
  }

  @Override
  public void showMessage(@StringRes int resId) {
    showMessage(getString(resId));
  }

  @Override
  public boolean isNetworkConnected() {
    return NetworkUtils.isNetworkConnected(getApplicationContext());
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  protected abstract void setUp();

}
