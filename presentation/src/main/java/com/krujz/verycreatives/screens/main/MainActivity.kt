package com.krujz.verycreatives.screens.main

import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.krujz.verycreatives.R.*
import com.krujz.verycreatives.screens.common.activity.BaseActivity
import com.krujz.verycreatives.screens.common.contracts.MainContract
import com.krujz.verycreatives.screens.common.gridview.CustomGrid


class MainActivity : BaseActivity(), MainContract.View {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout.main_activity)
        val navHostFragment =
            supportFragmentManager.findFragmentById(id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
     }


    override fun showHomeFragment() {
        TODO("Not yet implemented")
    }

    override fun showMovieDetailFragment() {
        TODO("Not yet implemented")
    }
}