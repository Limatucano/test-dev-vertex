package com.matheus.vertexapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.matheus.vertexapp.R
import com.matheus.vertexapp.data.repository.VideoRespository
import com.matheus.vertexapp.databinding.FragmentSearchBinding
import com.matheus.vertexapp.viewmodel.VideoViewModel
import com.matheus.vertexapp.viewmodel.VideoViewModelFactory
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {

    private lateinit var viewBinding : FragmentSearchBinding
    private lateinit var viewModel : VideoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel =  ViewModelProvider(this, VideoViewModelFactory(VideoRespository())).get(VideoViewModel::class.java)

        btnSearch.setOnClickListener {
            viewModel.filterVideos(query = inputSearch.text.toString())
        }
        viewModel.allVideo.observe(requireActivity(),{
            val direction = SearchFragmentDirections.actionSearchFragmentToResultFragment(it)
            view.findNavController().navigate(direction)
        })
        viewModel.failToGetAllVideos.observe(requireActivity(),{
            Toast.makeText(requireActivity(),it,Toast.LENGTH_SHORT).show()
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSearchBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

}