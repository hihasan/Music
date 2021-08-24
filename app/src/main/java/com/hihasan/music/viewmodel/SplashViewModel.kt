package com.hihasan.music.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hihasan.music.constants.ApplicationConstants
import com.hihasan.music.utils.BaseDatabase
import com.hihasan.music.utils.MusicApplication
import com.hihasan.music.views.MainActivity

class SplashViewModel:ViewModel() {
    var version = MutableLiveData<String>()
    var context: Context? = null
    var database: BaseDatabase? = null

    init {
        context = MusicApplication.getAppContext()

    }

    fun waitScreen(ctx: Context, database: BaseDatabase) {

        Handler().postDelayed({
            val intent:Intent

            intent = Intent(ctx, MainActivity::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ctx.startActivity(intent)

        }, ApplicationConstants.APP_LOAD_TIME)
    }
}