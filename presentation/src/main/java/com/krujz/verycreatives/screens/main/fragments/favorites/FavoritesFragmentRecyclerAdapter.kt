package com.krujz.verycreatives.screens.main.fragments.favorites

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
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
        holder.setOnClickListener(listOfMovies.elementAt(position).id)
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
        private val recyclerViewCardView = root.findViewById<CardView>(R.id.recycler_item_cardview)
        private val imageView : ImageView = root.findViewById(R.id.movie_image)
        private val progressBar : ProgressBar = root.findViewById(R.id.recycler_loading_progress_bar)

        fun setModelIntoRecyclerItem(movie: MovieItemData) {
            loadImage(movie)
            recyclerItemMovieCardModelBinding.movieModel = movie
        }

        fun setOnClickListener(movieId: Int){
            recyclerViewCardView.setOnClickListener {
                val bundle = getBundleOfMovieId(movieId)
                Navigation.findNavController(root).navigate(R.id.action_navigation_favorites_to_navigation_movie_details,bundle);
            }
        }

        private fun getBundleOfMovieId(movieId: Int) : Bundle {
            val bundle = Bundle()
            bundle.putInt("movieId", movieId)
            bundle.putString("prevFragment", FavoritesFragment.TAG)
            return bundle
        }

        private fun loadImage(movie: MovieItemData){
            imageLoader.loadImageUrlIntoImageViewWithProgressBar(movie.posterPath, imageView, progressBar)
        }
    }
}