package com.esif.esif.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.esif.esif.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SAWADOGO Badini Ibrahim on 24,février,2018.
 * Cette permet la gestion de tout ce qui est commun à l'application
 * Par exemple l'ffichage d'un progressBar, ou la validation de l'email
 * Lors de la connexion
 */

public class CommonUtils {


  /**
   * Cette fonction static permet la validation d'email
   * @param email email à valide
   * @return true si bon et false sinon
   */
  public static boolean isEmailValid(String email) {
    Pattern pattern;
    Matcher matcher;
    final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    pattern = Pattern.compile(EMAIL_PATTERN);
    matcher = pattern.matcher(email);
    return matcher.matches();
  }

  /**
   * Cette fonction d'affiche une barre de progression
   * @param context le context de l'application
   * @return le progressDialog
   */
  public static ProgressDialog showLoadingDialog(Context context) {
    ProgressDialog progressDialog = new ProgressDialog(context);
    progressDialog.show();
    if (progressDialog.getWindow() != null) {
      progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
    progressDialog.setContentView(R.layout.progress_dialog);
    progressDialog.setIndeterminate(true);
    progressDialog.setCancelable(false);
    progressDialog.setCanceledOnTouchOutside(false);
    return progressDialog;
  }

}
