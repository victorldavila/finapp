package com.finapp.dagger.module

import android.content.Context
import com.finapp.persistence.DebitDao
import com.finapp.persistence.FinappDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
  @Provides
  @Singleton
  fun provideFinappDatabase(context: Context): FinappDatabase =
      FinappDatabase.getInstance(context) ?: throw IllegalStateException("Can't get query database")

  @Provides
  @Singleton
  fun provideDebitDao(finappDatabase: FinappDatabase): DebitDao = finappDatabase.debitDao()
}