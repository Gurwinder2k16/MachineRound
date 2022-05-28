package com.phonepee.machineround.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phonepee.machineround.R
import com.phonepee.machineround.home.models.response.ResultsItem
import com.phonepee.machineround.utils.imageutils.ImageUtilsModules
import com.phonepee.machineround.utils.network.NetworkConstants
import kotlinx.android.synthetic.main.item_view_movie_list.view.*
import javax.inject.Inject

class MovieListAdapter(var movieList:ArrayList<ResultsItem?>, var pMovieListCallBack:MovieListCallBack): RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return MovieListViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_view_movie_list, parent, false),
            movieList,
            pMovieListCallBack
        )
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.onBind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieListViewHolder(itemView: View,
                              movieList:ArrayList<ResultsItem?>,
                              pMovieListCallBack:MovieListCallBack,
    ) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                pMovieListCallBack.onMovieSelected(movieList[adapterPosition])
            }
        }

        fun onBind(resultsItem: ResultsItem?) {
            resultsItem?.let {
                ImageUtilsModules.newInstance().downloadImage(NetworkConstants.sImagebaseURL.plus(resultsItem.backdropPath?:""),itemView.tvMovieThumb)
                itemView.tvHeader.text = resultsItem.originalTitle
                itemView.tvSubHeader.text = resultsItem.overview
            }
        }

    }
}


interface MovieListCallBack{

    fun onMovieSelected(resultsItem: ResultsItem?)
}
