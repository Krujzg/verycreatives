package com.krujz.verycreatives.screens.main.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.krujz.application.entities.MovieEntity
import com.krujz.application.mappers.ICollectionItemsMapper
import com.krujz.application.repository_interfaces.IMovieRepository
import com.krujz.domain.models.MovieModel
import com.krujz.verycreatives.R
import com.krujz.verycreatives.screens.common.contracts.HomeContract
import com.krujz.verycreatives.screens.common.fragment.BaseFragment
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : BaseFragment(), HomeContract.View {

    lateinit var collectionOfMovies: ArrayList<MovieModel>
    @Inject
    lateinit var presenter : HomeContract.Presenter

    override fun onStart() {
        super.onStart()
    }

    fun ffddd(){
        coroutineScope.launch {
            collectionOfMovies = presenter.getPopularMovies(1) as ArrayList<MovieModel>
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        ffddd()
        var asd = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }
}