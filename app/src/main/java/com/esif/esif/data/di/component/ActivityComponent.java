package com.esif.esif.data.di.component;

import com.esif.esif.data.di.PerActivity;
import com.esif.esif.data.di.module.ActivityModule;
import com.esif.esif.main.MainActivity;

import dagger.Component;

/**
 * Created by SAWADOGO Badini Ibrahim on 27,mars,2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
  void inject(MainActivity activity);


}
