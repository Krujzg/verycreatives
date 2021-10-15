package com.krujz.verycreatives.screens.main.fragments.favorites

import com.krujz.domain.models.MovieItemData

interface IMovieRecyclerViewAdapter {
    fun addMoviesToTheRecyclerView(listOfMovies: Collection<MovieItemData>)

    fun clearListOfMovies()
}