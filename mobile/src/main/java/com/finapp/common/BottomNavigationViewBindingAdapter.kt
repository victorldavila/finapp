package com.finapp.common

import android.support.design.widget.BottomNavigationView
import android.databinding.BindingAdapter


object BottomNavigationViewBindingAdapter {
  @BindingAdapter("onNavigationItemSelected")
  @JvmStatic
  fun setOnNavigationItemSelectedListener(
      view: BottomNavigationView,
      listener: BottomNavigationView.OnNavigationItemSelectedListener
  ) {
    view.setOnNavigationItemSelectedListener(listener)
  }
}