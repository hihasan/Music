package com.hihasan.music.views.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hihasan.music.databinding.FragmentHomeBinding
import com.hihasan.music.utils.BaseFragment

class HomeFragment: BaseFragment() {
    var binding:FragmentHomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Hihasan", "I Came here")
//        initListeners()
//        setupViewPager()
    }

}