package com.finapp.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.finapp.common.Converters
import com.finapp.entity.*

@Database(entities = [
  Debit::class,
  Credit::class,
  User::class,
  Investment::class,
  Deposit::class,
  Withdrawal::class
], version = 1)
@TypeConverters(Converters::class)
abstract class FinappDatabase : RoomDatabase() {

  abstract fun debitDao(): DebitDao

  companion object {
    private var INSTANCE: FinappDatabase? = null

    fun getInstance(context: Context): FinappDatabase? {
      if (INSTANCE == null) {
        synchronized(FinappDatabase::class) {
          INSTANCE = Room.databaseBuilder(context.applicationContext,
              FinappDatabase::class.java, "finapp.db")
              .build()
        }
      }
      return INSTANCE
    }

    fun destroyInstance() {
      INSTANCE = null
    }
  }
}