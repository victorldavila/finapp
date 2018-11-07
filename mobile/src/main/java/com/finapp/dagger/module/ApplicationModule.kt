package com.finapp.dagger.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

@Module
class ApplicationModule {
  @Provides
  fun provideApplicationContext(application: Application): Context = application

  @Provides
  fun provideBackgroundScheduler(): Scheduler = Schedulers.io()

  /*@Provides
  @Singleton
  internal fun provideSharedPreferences(context: Context): SharedPreferences {
    val preferencesFile = context.getString(R.string.preference_file_key)
    return context.getSharedPreferences(preferencesFile, Context.MODE_PRIVATE)
  }*/
}