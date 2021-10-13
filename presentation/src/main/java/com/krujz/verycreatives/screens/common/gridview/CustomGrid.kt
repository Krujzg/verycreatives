package com.krujz.verycreatives.screens.common.gridview

import android.content.Context

import android.widget.TextView

import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup

import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import com.krujz.verycreatives.R
import com.krujz.verycreatives.screens.common.imageloader.IImageLoader


class CustomGrid(private val mContext: Context,
                 private val movieTitles: Array<String>,
                 private val imageUrls: Array<String>,
                 private val imageLoader: IImageLoader) :
    BaseAdapter() {

    override fun getCount(): Int {
        return movieTitles.size
    }

    override fun getItem(position: Int): Any? {
        return movieTitles[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var grid: View
        val inflater = mContext
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (convertView == null) {
            grid = inflater.inflate(R.layout.grid_item, null)
            val textView : TextView = grid.findViewById(R.id.grid_text)
            val imageView: ImageView = grid.findViewById(R.id.grid_image)
            val progressBar: ProgressBar = grid.findViewById(R.id.loading_progress_bar)
            textView.text = movieTitles[position]
            imageLoader.loadImageUrlIntoImageViewWithProgressBar(imageUrls[position],imageView, progressBar)
        } else {
            grid = convertView as View
        }
        return grid
    }
}