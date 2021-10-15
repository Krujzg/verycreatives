package com.krujz.verycreatives.dependencyinjection.presentation

import com.krujz.verycreatives.screens.main.MainActivity
import com.krujz.verycreatives.screens.main.fragments.favorites.FavoritesFragment
import com.krujz.verycreatives.screens.main.fragments.home.HomeFragment
import com.krujz.verycreatives.screens.main.fragments.moviedetails.MovieDetailsFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {

    fun inject(mainActivity : MainActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(inventoryFragment: MovieDetailsFragment)
    fun inject(favoritesFragment: FavoritesFragment)
}