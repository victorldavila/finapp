package com.finapp.dagger.module

import android.arch.lifecycle.ViewModel
import com.finapp.features.main.MainViewModel
import com.finapp.dagger.key.ViewModelKey
import com.finapp.features.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel::class)
  abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(HomeViewModel::class)
  abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}