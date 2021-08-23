package com.hihasan.music.utils

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.DisplayMetrics
import android.view.View
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.hihasan.music.R
import com.hihasan.music.constants.ApplicationConstants.MUSIC_FOLDER
import com.hihasan.music.constants.DatabaseConstants
import java.io.ByteArrayOutputStream
import java.io.File

open class BaseFragment : Fragment() {
    //base of all fragment class
    var dialogUtil: DialogUtil? = null
    var BaseContext: Context? = null
    var bitmap: Bitmap? = null
    var database: BaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initialize dialog utils class for getting dialog util object
        dialogUtil = DialogUtil(activity)
        BaseContext = activity

        database = activity?.let {
            Room.databaseBuilder(it, BaseDatabase::class.java, DatabaseConstants.DATABASE_NAME)
                .allowMainThreadQueries()
                .build()
        }


    }


    //method for fragment replace getChildFragmentManager()
    protected fun initFragment(fragment: Fragment, id: String, resId: Int) {
        childFragmentManager
            .beginTransaction()
            .add(resId, fragment, id)
            .addToBackStack(null)
            .commit()
    }

    fun replaceFragment(fragment: Fragment?, newid: String?, oldId: String?, resId: Int) {
        Singleton.getInstance().whichFragmentItIs = fragment
        fragmentManager
            ?.beginTransaction()
            ?.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right)
            ?.replace(resId, fragment!!, newid)
            ?.addToBackStack(oldId)
            ?.commit()
    }
    fun showTurnOnInternetAlartDialog(){
        val alertDialogBuilder: MaterialAlertDialogBuilder = MaterialAlertDialogBuilder(requireContext())
        alertDialogBuilder.setMessage("Please check your internet connection or turn on Online")
        alertDialogBuilder.setCancelable(true)

        alertDialogBuilder.setPositiveButton(
            getString(android.R.string.ok)
        ) { dialog, _ ->
            dialog.cancel()
        }

        val alertDialog: androidx.appcompat.app.AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    //method for network available or not checking
    val isNetworkAvailable: Boolean
        get() {
            val connectivityManager = activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
        }

    //method for string concat
    fun concat(A: Array<String?>, B: Array<String?>): Array<String?> {
        val aLen = A.size
        val bLen = B.size
        val C = arrayOfNulls<String>(aLen + bLen)
        System.arraycopy(A, 0, C, 0, aLen)
        System.arraycopy(B, 0, C, aLen, bLen)
        return C
    }

    //method for load data from array
    fun loadArray(arrayName: String, mContext: Context): Array<String?> {
        val prefs = mContext.getSharedPreferences("preferencename", 0)
        val size = prefs.getInt(arrayName + "_size", 0)
        val array = arrayOfNulls<String>(size)
        for (i in 0 until size) array[i] = prefs.getString(arrayName + "_" + i, null)
        return array
    }

    //method for save data in array
    fun saveArray(array: Array<String?>, arrayName: String, mContext: Context): Boolean {
        val prefs = mContext.getSharedPreferences("preferencename", 0)
        val editor = prefs.edit()
        editor.putInt(arrayName + "_size", array.size)
        for (i in array.indices) editor.putString(arrayName + "_" + i, array[i])
        return editor.commit()
    }

    //method for convert bitmap to biye array
    protected fun convertBitmaptoByteArray(relativeLayout: ScrollView): ByteArray {
        bitmap = getBitmapFromView(relativeLayout, relativeLayout.getChildAt(0).height, relativeLayout.getChildAt(0).width)
        val bStream = ByteArrayOutputStream()
        bitmap!!.compress(Bitmap.CompressFormat.PNG, 100, bStream)
        return bStream.toByteArray()
    }

    //method for get bitmap
    protected fun getBitmapFromView(view: View, height: Int, width: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val bgDrawable = view.background
        if (bgDrawable != null) bgDrawable.draw(canvas) else canvas.drawColor(Color.WHITE)
        view.draw(canvas)
        return bitmap
    }

    //method for return screen size
    val screenSIze: IntArray
        get() {
            val displaymetrics = DisplayMetrics()
            activity?.windowManager?.defaultDisplay?.getMetrics(displaymetrics)
            val h = displaymetrics.heightPixels
            val w = displaymetrics.widthPixels
            return intArrayOf(w, h)
        }

    companion object {
        @JvmStatic
        fun showToast(ctx: Context?, msg: String?) {
            Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
        }
    }

    open fun reloadPage() {}

    open fun showWait(msg: String?, context: Context?) {
        dialogUtil = DialogUtil(context)
        dialogUtil!!.showProgressDialog(msg)
    }

    open  fun hideWait() {
        if (dialogUtil == null) return
        dialogUtil!!.dismissProgress()
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
                    activity?.getSystemService(AppCompatActivity.DOWNLOAD_SERVICE) as DownloadManager
                val referenceID = downloadManager.enqueue(request)
            }
        }
        return path
    }


}