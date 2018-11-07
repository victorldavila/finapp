package com.finapp.common

import android.databinding.BindingAdapter
import android.support.design.widget.BottomNavigationView
import android.widget.ImageView

object ImageBindingAdapter {
  @BindingAdapter("loadImageRsc")
  @JvmStatic
  fun loadImageRsc(
      view: ImageView,
      src: Int
  ) {
    view.setImageResource(src)
  }
}