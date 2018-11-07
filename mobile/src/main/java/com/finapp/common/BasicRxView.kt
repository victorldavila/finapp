package com.finapp.common

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface BasicRxView {
  val compositeDisposable: CompositeDisposable

  fun clearDisposables() = compositeDisposable.clear()

  fun Disposable.compose() = compositeDisposable.add(this)
}