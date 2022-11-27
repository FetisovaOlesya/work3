package com.example.databaserecipe.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.bam.viewmodelexample.adapters.RecipeDataListAdapter
import com.example.databaserecipe.R
import com.example.databaserecipe.databinding.FragmentListBinding
import com.example.databaserecipe.list.ListFragmentViewModel

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var viewModel: ListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)

        viewModel = ViewModelProvider(requireActivity())[ListFragmentViewModel::class.java]
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RecipeDataListAdapter()
        binding.entityList.adapter = adapter


        viewModel.list.observe(requireActivity()) {
            adapter.items = it
        }

        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_listFragment_to_editFragment)
        }
    }

    fun onShowCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RecipeDataListAdapter()
        binding.entityList.adapter = adapter


        viewModel.list.observe(requireActivity()) {
            adapter.items = it
        }

        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_listFragment_to_showFragment)
        }
    }
}