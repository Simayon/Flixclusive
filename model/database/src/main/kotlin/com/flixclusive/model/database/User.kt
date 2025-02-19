package com.flixclusive.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

private const val USER_DEFAULT_NAME = "User"

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("userId")
    val id: Int = 1,
    val name: String = USER_DEFAULT_NAME,
    val image: Int = 0
)