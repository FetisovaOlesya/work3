package com.bam.viewmodelexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.databaserecipe.R
import com.example.databaserecipe.databinding.RecipeItemBinding
import com.example.databaserecipe.room.RecipeData

class RecipeDataListAdapter : RecyclerView.Adapter<RecipeDataListAdapter.ViewHolder>() {

    var items: List<RecipeData> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var itemClick: (RecipeData) -> Unit = {}
    fun itemClick(listener: (RecipeData) -> Unit) {
        itemClick = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.recipe = items[position]
        holder.itemView.setOnClickListener {
            itemClick(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = RecipeItemBinding.bind(view)

    }
}