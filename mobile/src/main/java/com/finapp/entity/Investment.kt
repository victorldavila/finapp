package com.finapp.entity

import android.arch.persistence.room.*
import java.util.*

@Entity(indices = [Index(value = ["userId"], unique = true)],
    foreignKeys = [ForeignKey (entity = User::class,
    parentColumns = ["userId"],
    childColumns = ["userId"],
    onDelete = ForeignKey.CASCADE)
])
data class Investment (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "investmentId") var id: Long?,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "tax") var tax: Float?,
    @ColumnInfo(name = "type") var type: Int,
    @ColumnInfo(name = "userId") var userId: Long
)