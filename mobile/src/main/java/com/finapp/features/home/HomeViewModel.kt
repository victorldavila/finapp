package com.finapp.features.home

import android.arch.lifecycle.MutableLiveData
import com.finapp.common.BasicViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    val dolarExchangeUserCase: DolarExchangeUserCase
): BasicViewModel() {
  val dolarExchangeState = MutableLiveData<DolarExchangeState>()
  val balanceState = MutableLiveData<BalanceState>()
  val investmentState = MutableLiveData<InvestmentState>()

  fun init(){
    dolarExchangeState.value = DolarExchangeState()
    balanceState.value = BalanceState()
    investmentState.value = InvestmentState()

    dolarExchangeUserCase
        .getExchangeTodayAndYesterday()
        .doOnSuccess { dolarExchangeState.value = (it) }
        .doOnError { dolarExchangeState.value = (DolarExchangeState()) }
        .subscribe()
        .compose()
  }
}