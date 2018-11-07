package com.finapp.features.money

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.finapp.R
import com.finapp.common.BasicDaggerFragment

class MoneyFragment : BasicDaggerFragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_graphics, container, false)
  }

  companion object {
    @JvmStatic
    fun newInstance() =
        MoneyFragment().apply {
          arguments = Bundle().apply {

          }
        }
  }
}