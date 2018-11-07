package com.finapp.common

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BasicViewModel : ViewModel(), BasicRxView {
  override val compositeDisposable = CompositeDisposable()
}