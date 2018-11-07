package com.finapp.features.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.finapp.R
import com.finapp.common.BasicDaggerFragment
import com.finapp.common.ViewModelFactory
import com.finapp.databinding.FragmentHomeBinding
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : BasicDaggerFragment() {
  @Inject lateinit var viewModeFactory: ViewModelFactory

  lateinit var viewModel: HomeViewModel

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    viewModel = ViewModelProviders.of(this, this.viewModeFactory).get(HomeViewModel::class.java)
    val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
    binding.viewModel = viewModel
    binding.setLifecycleOwner(this)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel.init()
  }

  companion object {
    @JvmStatic
    fun newInstance() =
        HomeFragment().apply {
          arguments = Bundle().apply {

          }
        }
  }
}