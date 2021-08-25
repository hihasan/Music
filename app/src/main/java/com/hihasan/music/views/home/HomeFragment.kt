package com.hihasan.music.views.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hihasan.music.R
import com.hihasan.music.databinding.FragmentHomeBinding
import com.hihasan.music.utils.BaseFragment

class HomeFragment: BaseFragment(), View.OnClickListener {
    var binding:FragmentHomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Hihasan", "I Came here")
        initListeners()
//        setupViewPager()
    }

    private fun initListeners() {
        binding!!.searchIv.setOnClickListener {
            findNavController().navigate(R.id.nav_home_to_nav_search)
        }
    }

    override fun onClick(view: View?) {
//        when{
//
//        }
    }


}