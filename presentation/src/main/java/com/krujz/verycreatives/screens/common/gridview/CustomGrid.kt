package com.krujz.verycreatives.screens.common.gridview

import android.content.Context

import android.widget.TextView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup

import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import com.krujz.domain.models.GridMovieDataWrapper
import com.krujz.verycreatives.R
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader


class CustomGrid(private val mContext: Context,
                 private val data: ArrayList<GridMovieDataWrapper>,
                 private val imageLoader: IImageLoader) :
    BaseAdapter() {

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any? {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var grid: View = inflater.inflate(R.layout.grid_item, null)
        val titleTextview : TextView = grid.findViewById(R.id.grid_text)
        val voteAverageTextView: TextView = grid.findViewById(R.id.vote_average)
        val posterImageView: ImageView = grid.findViewById(R.id.grid_image)
        val progressBar: ProgressBar = grid.findViewById(R.id.loading_progress_bar)
        titleTextview.text = data[position].title
        voteAverageTextView.text = "${data[position].voteAverage}"
        imageLoader.loadImageUrlIntoImageViewWithProgressBar(data[position].posterPath,posterImageView, progressBar)
        return grid
    }
}