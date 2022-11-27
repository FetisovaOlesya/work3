package com.example.databaserecipe.room


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RecipeData::class], version = 1)
abstract class DbConnection : RoomDatabase() {
    abstract fun entityDao(): RecipeDao
}