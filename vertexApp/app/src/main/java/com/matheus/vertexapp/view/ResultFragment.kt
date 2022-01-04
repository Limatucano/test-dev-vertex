package com.matheus.vertexapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.matheus.vertexapp.R
import com.matheus.vertexapp.data.model.VideoResponse
import com.matheus.vertexapp.data.model.VideosResponse
import com.matheus.vertexapp.databinding.FragmentResultBinding
import com.matheus.vertexapp.view.adapter.VideosAdapter
import com.matheus.vertexapp.viewmodel.VideoViewModel
import kotlinx.android.synthetic.main.fragment_result.*


class ResultFragment : Fragment(), VideosAdapter.OnClickItemListener {
    private lateinit var viewBinding : FragmentResultBinding
    private lateinit var viewModel : VideoViewModel
    private var videoItem : VideosResponse? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle == null) {
            Log.e("Bundle", "Erro ao transferir dados")
            return
        }
        val args = ResultFragmentArgs.fromBundle(bundle)
        videoItem = args.videos

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewBinding.btnBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_resultFragment_to_searchFragment)
        }

        val layoutManager = LinearLayoutManager(context)
        rvVideos.layoutManager = layoutManager
        rvVideos.adapter = videoItem?.let { VideosAdapter(it.items, this) }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentResultBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onItemClick(item: VideoResponse, position: Int) {
        val direction = ResultFragmentDirections.actionResultFragmentToDetailVideoFragment(item)
        view?.findNavController()?.navigate(direction)
    }

}