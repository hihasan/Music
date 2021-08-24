package com.hihasan.music.views

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.hihasan.music.BuildConfig
import com.hihasan.music.R
import com.hihasan.music.databinding.ActivitySplashBinding
import com.hihasan.music.utils.BaseActivity
import com.hihasan.music.utils.MusicApplication
import com.hihasan.music.utils.Singleton
import com.hihasan.music.viewmodel.SplashViewModel

class SplashActivity: BaseActivity() {
    private var viewModel: SplashViewModel? = null
    var binding: ActivitySplashBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.version.text = MusicApplication.getResourceString(R.string.version) + " " + BuildConfig.VERSION_CODE

        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        viewModel!!.waitScreen(applicationContext, database!!)
        Singleton.getInstance().context = applicationContext

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }
}