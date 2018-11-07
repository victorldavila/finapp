package com.finapp.persistence

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.finapp.entity.Credit
import com.finapp.entity.Debit

@Dao
interface CreditDao {
  @Query("SELECT * FROM Credit WHERE userId = :userId AND creditDate BETWEEN date(:from) AND date(:to)")
  fun fetchCreditBetweenDate(from: String, to: String, userId: Long): LiveData<List<Debit>>

  @Query("SELECT * from Credit where userId = :userId ORDER BY id DESC LIMIT :limit")
  fun getAll(limit: Int, userId: Long): LiveData<List<Debit>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(weatherData: Credit)

  @Query("DELETE from Credit WHERE id = :creditId")
  fun deleteCreditById(creditId: Long)

  @Query("DELETE from Credit")
  fun deleteAll()
}