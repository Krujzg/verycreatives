package com.krujz.verycreatives.screens.main.fragments.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krujz.domain.models.MovieItemData
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

    private val recyclerAdapter = FavoritesFragmentRecyclerAdapter(requireContext(), imageLoader)

    private val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    private val recyclerView : RecyclerView = requireView().findViewById(R.id.favorites_recycler_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        getFavoriteMovies()
        setMovieRecyclerViewComponents()
        addMoviesToTheRecyclerView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.favorites_fragment, container, false)

    }

    private fun getFavoriteMovies(){
        coroutineScope.launch {
            collectionOfMovies.addAll(presenter.getFavoriteMovies() as ArrayList<MovieItemData>)
        }
    }

    private fun setMovieRecyclerViewComponents() {
        recyclerView.apply {
            adapter = recyclerAdapter as RecyclerView.Adapter<FavoritesFragmentRecyclerAdapter.FavoritesFragmentViewHolder>
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
}