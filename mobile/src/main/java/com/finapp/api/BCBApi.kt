package com.finapp.api

import com.finapp.entity.BCBApiResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BCBApi{
  @GET("dados/serie/bcdata.sgs.4390/dados/ultimos/{number}?formato=json")
  fun getLatestSelicTax(
      @Path("number") number: Int
  ): Single<List<BCBApiResponse>>

  @GET("dados/serie/bcdata.sgs.10813/dados/ultimos/{number}?formato=json")
  fun getLatestDolarValue(
      @Path("number") number: Int
  ): Single<List<BCBApiResponse>>
}