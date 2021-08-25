package com.hihasan.music.views.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hihasan.music.databinding.FragmentSettingsBinding
import com.hihasan.music.utils.BaseFragment

class SettingsFragment: BaseFragment() {
    var binding: FragmentSettingsBinding? =  null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Hihasan", "I Came here")
//        initListeners()
//        setupViewPager()
    }
}