package com.finapp.features.home

import com.finapp.R

data class DolarExchangeState(
    val yesterdayDolarValue: String = "- R$ 0.00",
    val todayDolarValue: String = "+ R$ 0.00",
    val differenceBetweenDays: String = "+ R$ 0.00",
    val differenceBetweenDaysColor: Int = R.color.green,
    val trendingImage: Int = R.drawable.ic_trending_up
)