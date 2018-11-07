package com.finapp.dagger.module

import com.finapp.features.FeatureModule
import com.finapp.features.main.MainActivity
import com.finapp.features.main.MainModule
import com.finapp.dagger.scope.MainScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

  @MainScope
  @ContributesAndroidInjector(
      modules = [
        MainModule::class,
        FeatureModule::class
      ]
  )
  internal abstract fun mainActivity(): MainActivity
}