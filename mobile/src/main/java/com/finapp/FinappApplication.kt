package com.finapp

import com.finapp.dagger.component.ApplicationComponent
import com.finapp.dagger.component.DaggerApplicationComponent
import com.google.android.gms.security.ProviderInstaller
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class FinappApplication : DaggerApplication() {
  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

    applicationComponent = DaggerApplicationComponent.builder()
        .application(this)
        .build()

    applicationComponent.inject(this)

    return applicationComponent
  }

  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG) {
    } else {
    }

    upgradeSecurityProvider()
  }

  private fun upgradeSecurityProvider() {
    ProviderInstaller.installIfNeeded(this)
  }

  companion object {
    lateinit var applicationComponent: ApplicationComponent
  }
}