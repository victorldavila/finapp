package com.finapp.dagger.component

import android.app.Application
import com.finapp.FinappApplication
import com.finapp.dagger.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
      AndroidSupportInjectionModule::class,
      ActivityBuilderModule::class,
      ApplicationModule::class,
      NetModule::class,
      ViewModelModule::class,
      ViewModelFactoryModule::class,
      RoomModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<FinappApplication> {
  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder

    fun build(): ApplicationComponent
  }
}