package com.finapp.features

import com.finapp.common.BasicDaggerFragment
import com.finapp.features.graphics.GraphicsFragment
import com.finapp.features.home.HomeFragment
import com.finapp.features.money.MoneyFragment
import com.finapp.features.timeline.TimelineFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FeatureModule {
  @ContributesAndroidInjector(modules = [])
  internal abstract fun basicFragment(): BasicDaggerFragment

  @ContributesAndroidInjector(modules = [])
  internal abstract fun homeFragment(): HomeFragment

  @ContributesAndroidInjector(modules = [])
  internal abstract fun graphicsFragment(): GraphicsFragment

  @ContributesAndroidInjector(modules = [])
  internal abstract fun moneyFragment(): MoneyFragment

  @ContributesAndroidInjector(modules = [])
  internal abstract fun timelineFragment(): TimelineFragment
}