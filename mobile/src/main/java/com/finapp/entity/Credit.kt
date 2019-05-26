package com.finapp.entity

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE
import java.util.*

@Entity(indices = [Index(value = ["userId"], unique = true)],
    foreignKeys = [ForeignKey (entity = User::class,
    parentColumns = ["userId"],
    childColumns = ["userId"],
    onDelete = CASCADE)
    ])
data class Credit (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "creditId") var id: Long?,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "creditDate") var date: Date,
    @ColumnInfo(name = "value") var value:Float,
    @ColumnInfo(name = "userId") var userId: Long
)