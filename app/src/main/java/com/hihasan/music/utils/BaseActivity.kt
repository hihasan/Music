package com.hihasan.music.utils

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.hihasan.music.constants.ApplicationConstants.MUSIC_FOLDER
import com.hihasan.music.constants.DatabaseConstants
import com.hihasan.music.views.MainActivity
import java.io.File

open class BaseActivity : AppCompatActivity(){

    public open var dataBinding: ViewDataBinding? = null
    var database: BaseDatabase? = null

    override fun onStart() {
        super.onStart()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initialize dialog utils class for getting dialog util object
        dialogUtil = DialogUtil(this)

        database = let {
            Room.databaseBuilder(it, BaseDatabase::class.java, DatabaseConstants.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
        }

    }


//    override fun setContentView(layoutResID: Int) {
//        val fullView: DrawerLayout = layoutInflater.inflate(R.layout.activity_base, null) as DrawerLayout
//        dataBinding = DataBindingUtil.inflate(layoutInflater, layoutResID, fullView.findViewById(R.id.activity_content), true)
//        super.setContentView(layoutResID)
//    }

    override fun onResume() {
        super.onResume()
    }
    override fun onStop() {
        super.onStop()
    }


    //method for fragment calling
    protected fun initFragment(fragment: Fragment, id: String?, resId: Int) {
        supportFragmentManager
            .beginTransaction()
            .add(resId, fragment, id)
            .addToBackStack(null)
            .commit()
    }

    //method for fragment replace
    protected fun replaceFragment(fragment: Fragment, id: String?, resId: Int) {
        supportFragmentManager
            .beginTransaction()
            .add(resId, fragment, id)
            .addToBackStack(id)
            .commit()
    }

    //method for going to homepage
    fun gotoHomePage() {
        val intent: Intent
        intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        finish()
        startActivity(intent)
    }

    //base of all activity class
    var dialogUtil: DialogUtil? = null
    open fun showToast(ctx: Context?, msg: String?) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
    }

    open fun showToast(msg: String?) {
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(applicationContext, msg, duration)
        toast.show()
    }

    open fun showWait(msg: String?, context: Context?) {
        dialogUtil = DialogUtil(context)
        dialogUtil!!.showProgressDialog(msg)
    }

    open  fun hideWait() {
        if (dialogUtil == null) return
        dialogUtil!!.dismissProgress()
    }

    open  fun showError(err: Any) {
        hideWait()
        if (err is Exception) {
            showToast(MusicApplication.getAppContext(), err.message)
        } else if (err is String) {
            showToast(MusicApplication.getAppContext(), err.toString())
        } else {
            showToast(MusicApplication.getAppContext(), "An error occurred")
        }
    }

    open fun setLocal(activity: Activity, langCode: String){
        val context: Context =
            LocaleContextWrapper.wrap(activity , langCode)
        resources.updateConfiguration(
            context.resources.configuration,
            context.resources.displayMetrics
        )

    }

    protected open fun downloadImage(url: String?): String? {
        var path = ""
        if (url != null) {
            val filename = url.substring(url.lastIndexOf("/") + 1)
            val file =
                File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).path + MUSIC_FOLDER + filename)
            path = file.path
            if (file.exists()) {
            } else {
                val request = DownloadManager.Request(Uri.parse(url))
                    .setTitle(filename)
                    .setDescription("Downloading")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
                    .setDestinationUri(Uri.fromFile(file))
                    .setAllowedOverMetered(true)
                    .setAllowedOverRoaming(true)
                val downloadManager =
                    applicationContext.getSystemService(DOWNLOAD_SERVICE) as DownloadManager
                val referenceID = downloadManager.enqueue(request)
            }
        }
        return path
    }

}