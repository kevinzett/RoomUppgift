package com.example.roomuppgift.roomdata

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName="Person")
data class Person (
    @PrimaryKey(autoGenerate = true)
    val uid: Int?,
    val firstName: String?,
    val lastName: String?
        )