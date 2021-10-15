package com.krujz.verycreatives.screens.main

import android.os.Bundle
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.appbar.AppBarLayout
import com.krujz.verycreatives.R
import com.krujz.verycreatives.R.id
import com.krujz.verycreatives.R.layout
import com.krujz.verycreatives.screens.common.activity.BaseActivity
import com.krujz.verycreatives.screens.common.contracts.MainContract

class MainActivity : BaseActivity(), MainContract.View {

    lateinit var navController: NavController

    lateinit var go_to_fav_fragment_button : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout.main_activity)

        val navHostFragment =
            supportFragmentManager.findFragmentById(id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        go_to_fav_fragment_button = findViewById(R.id.go_to_fav_fragment_button)
        setUpNavToFavoritesImageButtonClickListener()
     }


    override fun showHomeFragment() {
        navController.navigate(R.id.navigation_home)
    }

    override fun showFavoritesFragment() {
        navController.navigate(R.id.navigation_favorites)
    }

    private fun setUpNavToFavoritesImageButtonClickListener(){
        go_to_fav_fragment_button.setOnClickListener {
            showFavoritesFragment()
        }
    }
}