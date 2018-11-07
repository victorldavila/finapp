package com.finapp.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(foreignKeys = [ForeignKey (entity = User::class,
    parentColumns = ["id"],
    childColumns = ["userId"],
    onDelete = CASCADE)
    ])
data class Credit (
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "creditDate") var date: Date,
    @ColumnInfo(name = "value") var value:Float,
    @ColumnInfo(name = "userId") var userId: Long
)