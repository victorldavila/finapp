package com.finapp.features.main

import android.arch.lifecycle.ViewModel
import android.view.MenuItem
import com.finapp.common.BasicDaggerFragment
import com.finapp.R
import com.finapp.common.BasicViewModel
import com.finapp.features.FragmentDispatcher
import com.finapp.features.graphics.GraphicsFragment
import com.finapp.features.home.HomeFragment
import com.finapp.features.money.MoneyFragment
import com.finapp.features.timeline.TimelineFragment
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val fragmentDispatcher: FragmentDispatcher
): BasicViewModel() {

  fun init() = fragmentDispatcher.dispatch(HomeFragment.newInstance())

  fun onNavigationClick(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.tab_home -> fragmentDispatcher.dispatch(HomeFragment.newInstance())
      R.id.tab_graphics -> fragmentDispatcher.dispatch(GraphicsFragment.newInstance())
      R.id.tab_money -> fragmentDispatcher.dispatch(MoneyFragment.newInstance())
      R.id.tab_timeline -> fragmentDispatcher.dispatch(TimelineFragment.newInstance())
    }

    return true
  }
}