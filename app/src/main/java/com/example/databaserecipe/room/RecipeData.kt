package com.example.databaserecipe.room


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecipeData(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String,
    var description: String
)