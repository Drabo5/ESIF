package com.esif.esif.ui.base;

import com.esif.esif.data.DataManager;

import javax.inject.Inject;

/**
 * Created by SAWADOGO Badini Ibrahim on 24,février,2018.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

  private V mMvpView;
  private final DataManager mDataManager;


  @Inject
  public BasePresenter(DataManager dataManager) {
    this.mDataManager = dataManager;
  }


  @Override
  public void onAttach(V mvpView) {
    mMvpView = mvpView;
  }

  @Override
  public void onDetach() {
    mMvpView = null;
  }

  public boolean isViewAttached() {
    return mMvpView != null;
  }

  public V getMvpView() {
    return mMvpView;
  }

  public void checkViewAttached() {
    if (!isViewAttached()) throw new MvpViewNotAttachedException();
  }


  public DataManager getDataManager() {
    return mDataManager;
  }

  public static class MvpViewNotAttachedException extends RuntimeException {
    public MvpViewNotAttachedException() {
      super("Please call Presenter.onAttach(MvpView) before" +
        " requesting data to the Presenter");
    }
  }
}
