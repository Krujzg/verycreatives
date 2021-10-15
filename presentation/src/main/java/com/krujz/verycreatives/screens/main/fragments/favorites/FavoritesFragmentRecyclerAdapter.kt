package com.krujz.verycreatives.screens.main.fragments.favorites

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.krujz.domain.models.MovieItemData
import com.krujz.verycreatives.R
import com.krujz.verycreatives.databinding.RecyclerItemMovieCardModelBinding
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader

class FavoritesFragmentRecyclerAdapter(private val context: Context,
                                       private val imageLoader: IImageLoader) : RecyclerView.Adapter<FavoritesFragmentRecyclerAdapter.FavoritesFragmentViewHolder>(), IMovieRecyclerViewAdapter {

    private var listOfMovies : Collection<MovieItemData> = ArrayList(0)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesFragmentViewHolder {
        val itemView = RecyclerItemMovieCardModelBinding. inflate(LayoutInflater.from(context), parent, false)
        return FavoritesFragmentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoritesFragmentViewHolder, position: Int) {
        holder.setModelIntoRecyclerItem(listOfMovies.elementAt(position))
    }

    override fun getItemCount(): Int = listOfMovies.size

    override fun addMoviesToTheRecyclerView(listOfMovies: Collection<MovieItemData>) {
        this.listOfMovies = listOfMovies
        notifyDataSetChanged()
    }

    override fun clearListOfMovies() {
        listOfMovies.drop(listOfMovies.size)
        notifyDataSetChanged()
    }

    inner class FavoritesFragmentViewHolder(private val recyclerItemMovieCardModelBinding: RecyclerItemMovieCardModelBinding) : RecyclerView.ViewHolder(recyclerItemMovieCardModelBinding.root) {

        private val root = recyclerItemMovieCardModelBinding.root
        private val imageView : ImageView = root.findViewById(R.id.movie_image)
        private val progressBar : ProgressBar = root.findViewById(R.id.loading_progress_bar)

        fun setModelIntoRecyclerItem(movie: MovieItemData) {
            loadImage(movie)
            recyclerItemMovieCardModelBinding.movieModel = movie
        }

        private fun loadImage(movie: MovieItemData){
            imageLoader.loadImageUrlIntoImageViewWithProgressBar(movie.posterPath, imageView, progressBar)
        }
    }
}