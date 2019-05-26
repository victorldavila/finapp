package com.finapp.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

@Entity(indices = [Index(value = ["userId"], unique = true)])
data class User (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "userId") var id: Long?,
    @ColumnInfo(name = "firstName") var firstName: String,
    @ColumnInfo(name = "lastName") var lastName: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password: String
)