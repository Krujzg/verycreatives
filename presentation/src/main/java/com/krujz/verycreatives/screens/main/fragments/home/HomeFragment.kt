package com.krujz.verycreatives.screens.main.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.navigation.Navigation
import com.krujz.domain.models.MovieItemData
import com.krujz.verycreatives.R
import com.krujz.verycreatives.screens.common.contracts.HomeContract
import com.krujz.verycreatives.screens.common.dialogs.AlertDialogFragment
import com.krujz.verycreatives.screens.common.fragment.BaseFragment
import com.krujz.verycreatives.screens.common.gridview.CustomGrid
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader
import com.krujz.verycreatives.screens.main.MainActivity
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeContract.View {

    var collectionOfMovies: ArrayList<MovieItemData> = arrayListOf()
    @Inject
    lateinit var presenter : HomeContract.Presenter
    @Inject
    lateinit var imageLoader: IImageLoader

    private fun getMovieTypeFromBundle(): String{
        return when(arguments != null){
            true  -> requireArguments()["movieTypeTag"] as String
            false -> AlertDialogFragment.TOP_RATED_TAG
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        val movieType = getMovieTypeFromBundle()
        if (movieType.isNotEmpty()){
            getMovies(movieType)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)

    }

    private fun getMovies(movieType: String){
        coroutineScope.launch {
            collectionOfMovies.clear()
            when(movieType){
                AlertDialogFragment.TOP_RATED_TAG -> getTopRatedMovies()
                AlertDialogFragment.POPULAR_TAG -> getPopularMovies()
            }
            setMoviesIntoGridLayout()
        }
    }

    private suspend fun getTopRatedMovies(){
        collectionOfMovies.addAll(presenter.getTopRatedMovies(1) as ArrayList<MovieItemData>)
    }

    private suspend fun getPopularMovies(){
        collectionOfMovies.addAll(presenter.getPopularMovies(1) as ArrayList<MovieItemData>)
    }

    private fun setMoviesIntoGridLayout(){
        val adapter = CustomGrid(requireActivity() as MainActivity,collectionOfMovies,imageLoader)
        val grid = requireView().findViewById<View>(R.id.grid) as GridView
        grid.adapter = adapter
        grid.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val bundle = getBundleOfMovieId(collectionOfMovies[position].id)
            moveToMovieDetailsFragment(bundle)
        }
    }

    private fun moveToMovieDetailsFragment(bundle: Bundle){
        Navigation.findNavController(requireView()).navigate(R.id.action_navigation_home_to_navigation_movie_details,bundle);
    }

    private fun getBundleOfMovieId(movieId: Int) : Bundle{
        val bundle = Bundle()
        bundle.putInt("movieId", movieId)
        bundle.putString("prevFragment",TAG )
        return bundle
    }

    companion object{
        const val TAG = "HomeFragment"
    }
}