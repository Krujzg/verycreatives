package com.krujz.verycreatives.screens.main.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        coroutineScope.launch {
            collectionOfMovies = presenter.getPopularMovies(1) as ArrayList<MovieModel>
            var asd = ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }
}