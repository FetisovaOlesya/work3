package com.example.databaserecipe.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.databaserecipe.room.DbConnection
import com.example.databaserecipe.room.RecipeData
import kotlinx.coroutines.launch

class ListFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private val recipeEntityDao =
        Room.databaseBuilder(application, DbConnection::class.java, "database")
            .build()
            .entityDao()

    val list = recipeEntityDao.getAll()


    fun insert(recipeData: RecipeData){
        viewModelScope.launch {
            recipeEntityDao.insert(recipeData)
        }
    }

}