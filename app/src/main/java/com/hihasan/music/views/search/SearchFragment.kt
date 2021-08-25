package com.hihasan.music.views.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hihasan.music.databinding.FragmentHomeBinding
import com.hihasan.music.databinding.FragmentSearchBinding
import com.hihasan.music.utils.BaseFragment

class SearchFragment: BaseFragment(), View.OnClickListener {
    var binding: FragmentSearchBinding? =  null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Hihasan", "I Came here")
//        initListeners()
//        setupViewPager()
    }

    private fun initListeners() {
//        binding!!.s
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}