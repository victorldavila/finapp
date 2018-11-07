package com.finapp.repository

import com.finapp.api.BCBApi
import com.finapp.entity.BCBApiResponse
import io.reactivex.Single
import javax.inject.Inject

class DolarExchangeRepository @Inject constructor(
    val bcbApi: BCBApi
){
  fun getLatestDolarValue(): Single<List<BCBApiResponse>> = bcbApi.getLatestDolarValue(10)
}