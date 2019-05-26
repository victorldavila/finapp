package com.finapp.entity

import android.arch.persistence.room.*
import java.util.*

@Entity(indices = [Index(value = ["investmentId"], unique = true)],
    foreignKeys = [ForeignKey (entity = Investment::class,
    parentColumns = ["investmentId"],
    childColumns = ["investmentId"],
    onDelete = ForeignKey.CASCADE)
])
data class Deposit (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "depositId") var id: Long?,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "depositDate") var date: Date,
    @ColumnInfo(name = "value") var value: Float,
    @ColumnInfo(name = "investmentId") var investmentId: Long
)