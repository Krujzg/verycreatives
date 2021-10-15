package com.krujz.verycreatives.screens.main.fragments.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.R
import com.krujz.verycreatives.screens.common.contracts.MovieDetailsContract
import com.krujz.verycreatives.screens.common.fragment.BaseFragment
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader
import com.krujz.verycreatives.screens.main.fragments.favorites.FavoritesFragment
import com.krujz.verycreatives.screens.main.fragments.home.HomeFragment
import kotlinx.coroutines.launch
import javax.inject.Inject


class MovieDetailsFragment : BaseFragment(), MovieDetailsContract.View {

    var currentMovie: MovieModel? = null

    @Inject
    lateinit var presenter : MovieDetailsContract.Presenter
    @Inject
    lateinit var imageLoader: IImageLoader

    private lateinit var backButton : ImageButton
    private lateinit var favoriteStart: ImageButton
    private lateinit var movie_title: TextView
    private lateinit var movie_short_desc : TextView
    private lateinit var movie_image: ImageView
    private lateinit var movie_desc: TextView
    private var starButtonDrawable = R.drawable.ic_baseline_star_outline_24

    private fun setUiElements(){
        backButton = requireView().findViewById(R.id.back_button)
        favoriteStart = requireView().findViewById(R.id.favorite_star)
        movie_title = requireView().findViewById(R.id.movie_title)
        movie_short_desc  = requireView().findViewById(R.id.movie_short_desc)
        movie_image = requireView().findViewById(R.id.movie_image)
        movie_desc = requireView().findViewById(R.id.movie_desc)
    }
    private fun getMovieIdFromBundle(): Int{
        return requireArguments()["movieId"] as Int
    }

    private fun getPrevFragmentsTagFromBundle(): String{
        return requireArguments()["prevFragment"] as String
    }
    override fun onStart() {
        super.onStart()
        setUiElements()
        setUpBackButtonClickListeners()
        setUpFavoriteStarOnClickListener()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        getSelectedMovie()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.movie_details_fragment, container, false)

    }

    private fun setUi(){
        if (currentMovie != null){
            movie_title.text = currentMovie!!.title
            movie_short_desc.text = currentMovie!!.originalTitle
            imageLoader.loadImageUrlIntoImageView(currentMovie!!.posterPath, movie_image)
            movie_desc.text = currentMovie!!.overview
        }
    }

    private fun getSelectedMovie(){
        coroutineScope.launch {
            val selectedMovieId = getMovieIdFromBundle()
            currentMovie = presenter.getSelectedMovie(selectedMovieId)
            getSelectedMovieFavoriteStatus()
            setUi()
        }
    }

    private suspend fun getSelectedMovieFavoriteStatus(){
        coroutineScopeIO.launch {
            currentMovie!!.isFavorite = presenter.getSelectedMovieFavoriteStatus(currentMovie!!.id)
        }.join()
        setFavoriteStarImageDrawable()
    }

    private fun setFavoriteStarImageDrawable(){
        starButtonDrawable = when(currentMovie!!.isFavorite){
            true -> R.drawable.ic_baseline_star_24
            false -> R.drawable.ic_baseline_star_outline_24
        }
        favoriteStart.setImageResource(starButtonDrawable)
    }

    private fun setUpFavoriteStarOnClickListener(){
        favoriteStart.setOnClickListener {
            when(currentMovie!!.isFavorite){
                true -> {
                    coroutineScopeIO.launch {
                        presenter.deleteSelectedFavoriteMovie()
                        getSelectedMovieFavoriteStatus()
                    }
                }
                false ->{
                    coroutineScopeIO.launch {
                        presenter.addFavoriteMovie()
                        getSelectedMovieFavoriteStatus()
                    }
                }
            }

        }
    }

    private fun setUpBackButtonClickListeners(){
        backButton.setOnClickListener {
            navigateBack()
        }
    }

    private fun navigateBack(){
        var idOfTheNavigationAction = 0
        when(getPrevFragmentsTagFromBundle()){
            HomeFragment.TAG -> idOfTheNavigationAction = R.id.action_navigation_movie_details_to_navigation_home
            FavoritesFragment.TAG -> idOfTheNavigationAction = R.id.action_navigation_movie_details_to_navigation_favorites
        }
        Navigation.findNavController(requireView()).navigate(idOfTheNavigationAction);
    }
}