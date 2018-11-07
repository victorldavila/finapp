package com.finapp.common

import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class BasicActivity : DaggerAppCompatActivity(), BasicRxView {
  override val compositeDisposable = CompositeDisposable()
}