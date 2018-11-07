package com.finapp.features

import android.support.v4.app.Fragment
import com.finapp.dagger.scope.MainScope
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

@MainScope
class FragmentDispatcher
@Inject constructor() {
  private val fragmentDispatcher = PublishSubject.create<Fragment>()

  fun dispatch(fragment: Fragment) {
    fragmentDispatcher.onNext(fragment)
  }

  fun stream(): Observable<Fragment> = fragmentDispatcher
}