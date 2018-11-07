package com.finapp.features.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import com.finapp.common.BasicActivity
import com.finapp.R
import com.finapp.common.ViewModelFactory
import com.finapp.databinding.ActivityMainBinding
import com.finapp.features.FragmentDispatcher
import javax.inject.Inject

class MainActivity : BasicActivity() {
  @Inject lateinit var viewModeFactory: ViewModelFactory
  @Inject lateinit var fragmentDispatcher: FragmentDispatcher

  lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(MainViewModel::class.java)
    val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.viewModel = viewModel

    fragmentDispatcher.stream()
        .distinctUntilChanged()
        .doOnNext { changeFragment(it) }
        .subscribe()
        .compose()

    viewModel.init()
  }

  private fun changeFragment(fragment: Fragment?) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.contentContainer, fragment)
    transaction.addToBackStack(null)
    transaction.commit()
  }
}
