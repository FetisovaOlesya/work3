package com.example.databaserecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.databaserecipe.databinding.FragmentMainBinding

class MainFragment:Fragment(R.layout.fragment_main) {
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToRecipe.setOnClickListener {
           //MAIN.navController.navigate(R.id.action_mainFragment_to_listFragment)
           // Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_listFragment)
        }

    }
}