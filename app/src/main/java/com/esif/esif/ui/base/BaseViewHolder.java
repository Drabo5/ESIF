package com.esif.esif.ui.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by SAWADOGO Badini Ibrahim on 27,mars,2018.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder{

  private int mCurrentPosition;

  public BaseViewHolder(View itemView) {
    super(itemView);
  }

  public void onBind(int position) {
    mCurrentPosition = position;
  }

  public int getCurrentPosition(){
    return mCurrentPosition;
  }
}

