package com.example.roomuppgift.roomdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PersonDAO {
    @Insert
   suspend fun insert(person: Person)


    @Query("select * from Person")
    suspend fun display():List<Person>

}