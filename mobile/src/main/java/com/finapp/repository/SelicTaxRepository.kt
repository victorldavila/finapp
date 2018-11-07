package com.finapp.repository

import com.finapp.api.BCBApi
import com.finapp.entity.BCBApiResponse
import io.reactivex.Single
import javax.inject.Inject

class SelicTaxRepository @Inject constructor(
    val bcbApi: BCBApi
){
  fun getLatestSelicTax(): Single<List<BCBApiResponse>> = bcbApi.getLatestSelicTax(10)
}