package com.krujz.verycreatives.screens.main.fragments.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krujz.application.mappers.IMovieDataModelMapper
import com.krujz.domain.models.MovieItemData
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.R
import com.krujz.verycreatives.screens.common.contracts.FavoritesContract
import com.krujz.verycreatives.screens.common.fragment.BaseFragment
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritesFragment: BaseFragment(), FavoritesContract.View {

    private var collectionOfMovies: ArrayList<MovieItemData> = arrayListOf()


    @Inject
    lateinit var presenter: FavoritesContract.Presenter
    @Inject
    lateinit var imageLoader: IImageLoader
    @Inject
    lateinit var mapper: IMovieDataModelMapper<MovieModel, MovieItemData>

    private lateinit var recyclerAdapter : FavoritesFragmentRecyclerAdapter

    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView : RecyclerView

    override fun onStart() {
        super.onStart()
        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView = requireView().findViewById(R.id.favorites_recycler_view)
        recyclerAdapter = FavoritesFragmentRecyclerAdapter(requireView().context, imageLoader)
        setMovieRecyclerViewComponents()
        addMoviesToTheRecyclerView()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        getFavoriteMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.favorites_fragment, container, false)
    }

    private fun getFavoriteMovies(){
        coroutineScopeIO.launch {
            val arrayOfMovies = presenter.getFavoriteMovies()
            collectionOfMovies.addAll(mapper.mapToCollectionOfGridDataWrapper(arrayOfMovies))
        }
    }

    private fun setMovieRecyclerViewComponents() {
        recyclerView.apply {
            adapter = recyclerAdapter
            layoutManager = linearLayoutManager
        }
    }

    private fun addMoviesToTheRecyclerView(){
        clearMoviesFromTheRecyclerView()
        recyclerAdapter.addMoviesToTheRecyclerView(collectionOfMovies)
    }

    private fun clearMoviesFromTheRecyclerView(){
        recyclerAdapter.clearListOfMovies()
    }

    companion object{
        const val TAG = "FavoritesFragment"
    }
}