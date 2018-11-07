package com.finapp.features.home

import com.finapp.R
import com.finapp.repository.DolarExchangeRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import kotlin.math.absoluteValue

class DolarExchangeUserCase @Inject constructor(
    val dolarExchangeRepository: DolarExchangeRepository
) {
  fun getExchangeTodayAndYesterday(): Single<DolarExchangeState> =
      dolarExchangeRepository.getLatestDolarValue()
          .map {
            DolarExchangeState(
              "- R$ ${it[0].value}",
                "+ R$ ${it[1].value}",
                if ((it[0].value.toFloat() - it[1].value.toFloat()) <= 0) "+ R$ ${(it[0].value.toFloat() - it[1].value.toFloat()).absoluteValue}"
                else "- R$ ${(it[0].value.toFloat() - it[1].value.toFloat()).absoluteValue}",
                if ((it[0].value.toFloat() - it[1].value.toFloat()) <= 0) R.color.green else R.color.red,
                if ((it[0].value.toFloat() - it[1].value.toFloat()) <= 0) R.drawable.ic_trending_up else R.drawable.ic_trending_down
            )
          }
          .observeOn(AndroidSchedulers.mainThread())
}