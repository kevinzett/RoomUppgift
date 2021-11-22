package com.example.roomuppgift.roomdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version=1)
abstract class PersonDatabase:RoomDatabase() {
    abstract fun personDao(): PersonDAO
    companion object {
        var INSTANCE: PersonDatabase? = null
        fun getInstance(context: Context):PersonDatabase {
            if (INSTANCE==null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    PersonDatabase::class.java,
                    "Person.db").build()
            }
            return INSTANCE!!
        }
    }
}
