package com.finapp.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(foreignKeys = [ForeignKey (entity = Investment::class,
    parentColumns = ["id"],
    childColumns = ["investmentId"],
    onDelete = ForeignKey.CASCADE)
])
data class Deposit (
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "depositDate") var date: Date,
    @ColumnInfo(name = "value") var value: Float,
    @ColumnInfo(name = "ivestmentId") var investmentId: Long
)