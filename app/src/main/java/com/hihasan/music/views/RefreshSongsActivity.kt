package com.hihasan.music.views

import android.os.Bundle
import com.hihasan.music.databinding.ActivityRefreshBinding
import com.hihasan.music.utils.BaseActivity
import com.hihasan.music.utils.Singleton

class RefreshSongsActivity: BaseActivity() {

    private var binding: ActivityRefreshBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefreshBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        Singleton.getInstance().context = applicationContext

        initListeners()
    }

    private fun initListeners() {
        TODO("Not yet implemented")
    }
}