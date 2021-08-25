package com.hihasan.music.views.playlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hihasan.music.databinding.FragmentPlaylistBinding
import com.hihasan.music.utils.BaseFragment

class PlaylistFragment:BaseFragment() {
    var binding: FragmentPlaylistBinding? =  null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Hihasan", "I Came here")
//        initListeners()
//        setupViewPager()
    }
}