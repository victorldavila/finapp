package com.finapp.features.home

import com.finapp.R

data class BalanceState(
    val balanceValue: String = "+ R$ 0.00",
    val balanceTextColor: Int = R.color.green,
    val balanceImage: Int = R.drawable.ic_trending_up
)