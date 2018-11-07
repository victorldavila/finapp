package com.finapp.common

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable

open class BasicDaggerFragment: DaggerFragment(), BasicRxView {
  override val compositeDisposable = CompositeDisposable()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setHasOptionsMenu(true)
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    super.onCreateOptionsMenu(menu, inflater)
    menu.clear()
  }
}