package com.finapp.dagger.module

import android.content.Context
import android.support.constraint.solver.Cache
import com.finapp.BuildConfig
import com.finapp.api.BCBApi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {

  /*@Provides
  fun provideCache(context: Context): Cache {
    return Cache(context.cacheDir, 15 * 1024 * 1024)
  }*/

  @Provides
  @Named("logging")
  fun provideLoggingInterceptor(): Interceptor {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return interceptor
  }

  /*@Provides
  @Named("headers")
  fun provideAddHeadersInterceptor(
      preferences: UserPreferences,
      context: Context
  ): Interceptor {
    return Interceptor { chain ->
      val original = chain.request()

      val requestBuilder = original.newBuilder()
          .addHeader("appVersionName", BuildConfig.VERSION_NAME)
          .addHeader("appVersionCode", "${BuildConfig.VERSION_CODE}")
          .addHeader("appPlatform", "Android")

      if (preferences.isLogged()) {
        val jwtToken = JWT.getToken(context, preferences)
        Timber.d("Authorization: Bearer $jwtToken")

        requestBuilder.addHeader("Authorization", "Bearer $jwtToken")
      }

      val request = requestBuilder.build()
      chain.proceed(request)
    }
  }*/

  @Provides
  @Singleton
  fun provideOkHttpClient(
      @Named("logging") httpLoggingInterceptor: Interceptor
      /*cache: Cache,,
      @Named("headers") addHeadersInterceptor: Interceptor*/
  ): OkHttpClient {
    val okHttpBuilder = OkHttpClient.Builder()
        //.cache(cache)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        //.addInterceptor(addHeadersInterceptor)

    if (BuildConfig.DEBUG)
      okHttpBuilder.addInterceptor(httpLoggingInterceptor)

    return okHttpBuilder.build()
  }

  @Provides
  @Singleton
  fun provideBCBApi(okHttpClient: OkHttpClient): BCBApi {
    val retrofit = Retrofit.Builder().baseUrl("http://api.bcb.gov.br")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .client(okHttpClient)
        .build()

    return retrofit.create(BCBApi::class.java)
  }
}