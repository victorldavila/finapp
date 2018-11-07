package com.finapp.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(foreignKeys = [ForeignKey (entity = User::class,
    parentColumns = ["id"],
    childColumns = ["userId"],
    onDelete = ForeignKey.CASCADE)
])
data class Investment (
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "tax") var tax: Float?,
    @ColumnInfo(name = "type") var type: Int,
    @ColumnInfo(name = "userId") var userId: Long
)