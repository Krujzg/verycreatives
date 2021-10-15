package com.krujz.verycreatives.screens.main

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.appbar.AppBarLayout
import com.krujz.verycreatives.R
import com.krujz.verycreatives.R.id
import com.krujz.verycreatives.R.layout
import com.krujz.verycreatives.screens.common.ISelectorOnButtonClick
import com.krujz.verycreatives.screens.common.activity.BaseActivity
import com.krujz.verycreatives.screens.common.contracts.MainContract
import com.krujz.verycreatives.screens.common.dialogs.AlertDialogFragment
import com.krujz.verycreatives.screens.common.dialogs.interfaces.IDialogNavigator
import com.krujz.verycreatives.screens.main.fragments.home.HomeFragment
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View , ISelectorOnButtonClick {

    lateinit var navController: NavController

    lateinit var go_to_fav_fragment_button : ImageButton
    lateinit var selector_imagebutton: ImageButton

    @Inject
    lateinit var dialogNavigator: IDialogNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout.main_activity)

        val navHostFragment =
            supportFragmentManager.findFragmentById(id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        go_to_fav_fragment_button = findViewById(id.go_to_fav_fragment_button)
        selector_imagebutton = findViewById(id.selector_imagebutton)
        setUpNavToFavoritesImageButtonClickListener()
        setUpSelectorImageButtonOnClickListener()
     }


    private fun getBundleOfMovieType(movieTypeTag: String) : Bundle{
        val bundle = Bundle()
        bundle.putString("movieTypeTag", movieTypeTag)
        return bundle
    }

    override fun showHomeFragment(movieTypeTag: String) {
        val bundle = getBundleOfMovieType(movieTypeTag)
        navController.navigate(id.navigation_home,bundle)
    }

    override fun showFavoritesFragment() {
        navController.navigate(id.navigation_favorites)
    }

    private fun setUpNavToFavoritesImageButtonClickListener(){
        go_to_fav_fragment_button.setOnClickListener {
            showFavoritesFragment()
        }
    }

    private fun setUpSelectorImageButtonOnClickListener(){
        selector_imagebutton.setOnClickListener {
            val dialog = AlertDialogFragment()
            dialog.show(supportFragmentManager, "tag")
        }
    }

    override fun onSelectorButtonClick(buttonTag: String) {
        showHomeFragment(buttonTag)
    }
}