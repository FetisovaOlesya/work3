package com.example.databaserecipe.room


import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Dao

@Dao
interface RecipeDao {

    @Query("select * from RecipeData")
    fun getAll(): LiveData<List<RecipeData>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(entity: RecipeData)
}