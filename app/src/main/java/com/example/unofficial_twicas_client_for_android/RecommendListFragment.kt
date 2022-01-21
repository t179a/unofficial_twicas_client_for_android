package com.example.unofficial_twicas_client_for_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.unofficial_twicas_client_for_android.databinding.FragmentRecommendListBinding


class RecommendListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentRecommendListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_recommend_list, container, false
        )

        /*if(savedInstanceState == null){
            Toast.makeText(activity, "bundle is null", Toast.LENGTH_SHORT).show()
        }*/

        //Bundleがnullで落ちる

        val accessToken: String? = arguments?.getString("accessToken")
        /*if(accessToken != null){
            Toast.makeText(activity, accessToken.toString(), Toast.LENGTH_SHORT).show()

        }*/

        val viewModelFactory = RecommendListViewModelFactory(accessToken!!)


        //val application = requireNotNull(this.activity).application

        val recommendlistViewModel = ViewModelProvider(this, viewModelFactory).get(RecommendListViewModel::class.java)
        binding.viewModel = recommendlistViewModel

        val adapter = RecommendListAdapter()
        binding.recommendList.adapter = adapter

        binding.setLifecycleOwner(this)

        recommendlistViewModel.movieList.observe(viewLifecycleOwner,  Observer {
            it?.let {
                adapter.submitList(it.movies)
            }
        })



        return binding.root
    }
}