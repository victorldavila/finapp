package com.finapp.persistence

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.finapp.entity.Debit

@Dao
interface DebitDao {
  @Query("SELECT * FROM Debit WHERE userId = :userId AND debitDate BETWEEN date(:from) AND date(:to)")
  fun fetchDebitBetweenDate(from: String, to: String, userId: Long): LiveData<List<Debit>>

  @Query("SELECT * from Debit where userId = :userId ORDER BY debitId DESC LIMIT :limit")
  fun getAll(limit: Int, userId: Long): LiveData<List<Debit>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(weatherData: Debit)

  @Query("DELETE from Debit WHERE debitId = :debitId")
  fun deleteDebitById(debitId: Long)

  @Query("DELETE from Debit")
  fun deleteAll()
}