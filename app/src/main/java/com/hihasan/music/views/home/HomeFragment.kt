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
import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.hihasan.music.model.SongModel
import java.lang.Exception
import java.lang.NumberFormatException
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment: BaseFragment(), View.OnClickListener {
    var binding:FragmentHomeBinding? = null
    var TAG: String = HomeFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()


    }

    private fun initListeners() {
        binding!!.searchIv.setOnClickListener {
            findNavController().navigate(R.id.nav_home_to_nav_search)
        }

        binding!!.settingsIv.setOnClickListener{
            findNavController().navigate(R.id.nav_home_to_nav_settings)
        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}