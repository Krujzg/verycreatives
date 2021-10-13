package com.krujz.verycreatives.screens.main.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.krujz.application.entities.MovieEntity
import com.krujz.application.mappers.ICollectionItemsMapper
import com.krujz.application.repository_interfaces.IMovieRepository
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

    lateinit var collectionOfMovies: ArrayList<MovieModel>
    @Inject
    lateinit var presenter : HomeContract.Presenter
    @Inject
    lateinit var imageLoader: IImageLoader


    override fun onStart() {
        super.onStart()
    }

    fun ffddd(){
        coroutineScope.launch {
            collectionOfMovies = presenter.getPopularMovies(1) as ArrayList<MovieModel>
            grid()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        ffddd()
    }

    fun grid(){
        val adapter = CustomGrid(requireActivity() as MainActivity,arrayOf<String>("Text", "Zombie") , arrayOf(collectionOfMovies[0].posterPath, collectionOfMovies[1].posterPath),imageLoader)
        val grid = requireView().findViewById<View>(R.id.grid) as GridView
        grid.setAdapter(adapter)
        grid.setOnItemClickListener(AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                context,
                "You Clicked at ",// + web.get(+position),
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)

    }
}
/*
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.VeryCreatives" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
        <item name="android:textColor">@color/white</item>
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/main_color</item>
        <item name="colorPrimaryVariant">@color/background</item>
        <item name="colorOnPrimary">@color/background</item>
        <!-- Secondary brand color. -->
        <item name="colorSecondary">@color/background</item>
        <item name="colorSecondaryVariant">@color/main_color</item>
        <item name="colorOnSecondary">@color/background</item>
    </style>

    <style name="Theme.VeryCreatives.NoActionBar">
        <item name="windowActionBar">false</item>
        <item name="windowNoTitle">true</item>
    </style>

    <style name="Theme.VeryCreatives.AppBarOverlay" parent="ThemeOverlay.AppCompat.ActionBar" />

    <style name="Theme.VeryCreatives.PopupOverlay" parent="ThemeOverlay.AppCompat.Light" />
</resources>
 */