package com.example.databaserecipe.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.databaserecipe.R
import com.example.databaserecipe.databinding.FragmentEditBinding
import com.example.databaserecipe.list.ListFragmentViewModel
import com.example.databaserecipe.room.RecipeData

class ShowFragment : Fragment() {

    lateinit var binding: FragmentEditBinding
    lateinit var viewModel: ListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater)

        viewModel = ViewModelProvider(requireActivity())[ListFragmentViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val name = binding.name.text.toString()
            val description = binding.description.text.toString()

            val recipe = RecipeData(name = name, description = description)
            viewModel.insert(recipe)
            Navigation.findNavController(it).navigate(R.id.action_showFragment_to_listFragment)
        }

    }


}

class FragmentShowBinding {

}
