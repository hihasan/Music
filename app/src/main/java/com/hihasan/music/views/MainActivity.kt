package com.hihasan.music.views

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import com.hihasan.boat.ExpandableBottomBar
import com.hihasan.boat.navigation.ExpandableBottomBarNavigationUI
import com.hihasan.music.R
import com.hihasan.music.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigationController = Navigation.findNavController(this, R.id.navigationHost)
        val expandableBottomBar = findViewById<ExpandableBottomBar>(R.id.bottomNavigation)
        ExpandableBottomBarNavigationUI.setupWithNavController(expandableBottomBar, navigationController)

    }
}