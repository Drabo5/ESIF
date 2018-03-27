package com.esif.esif.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by SAWADOGO Badini Ibrahim on 24,février,2018.
 * Cette class permet la gestion de la connexion
 */

public class NetworkUtils {

  private NetworkUtils() {}

  /**
   * Cette fonction permet la gestion de la connexion
   * @param context de l'application
   * @return true si connexion et false sinon
   */
  public static boolean isNetworkConnected(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
  }
}
