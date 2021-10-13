package com.krujz.verycreatives.screens.main.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.krujz.domain.models.GridMovieDataWrapper
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.R
import com.krujz.verycreatives.screens.common.contracts.HomeContract
import com.krujz.verycreatives.screens.common.fragment.BaseFragment
import com.krujz.verycreatives.screens.common.gridview.CustomGrid
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader
import com.krujz.verycreatives.screens.main.MainActivity
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeContract.View {

    lateinit var collectionOfMovies: ArrayList<GridMovieDataWrapper>
    @Inject
    lateinit var presenter : HomeContract.Presenter
    @Inject
    lateinit var imageLoader: IImageLoader


    override fun onStart() {
        super.onStart()
    }

    fun ffddd(){
        coroutineScope.launch {
            collectionOfMovies = presenter.getCollectionOfPopularGridMovieDataWrappers(1) as ArrayList<GridMovieDataWrapper>
            grid()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        ffddd()
    }

    fun grid(){
        val adapter = CustomGrid(requireActivity() as MainActivity,collectionOfMovies,imageLoader)
        val grid = requireView().findViewById<View>(R.id.grid) as GridView
        grid.adapter = adapter
        grid.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(context, "You Clicked at ", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)

    }
}