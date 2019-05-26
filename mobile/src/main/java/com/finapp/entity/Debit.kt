package com.finapp.entity

import android.arch.persistence.room.*
import java.util.*

@Entity(indices = [Index(value = ["userId"], unique = true)],
    foreignKeys = [ForeignKey (entity = User::class,
    parentColumns = ["userId"],
    childColumns = ["userId"],
    onDelete = ForeignKey.CASCADE)
])
data class Debit (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "debitId") var id: Long?,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "debitDate") var date: Date,
    @ColumnInfo(name = "value") var value:Float,
    @ColumnInfo(name = "userId") var userId: Long
)