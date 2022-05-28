package com.phonepee.machineround.home.fragments

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.phonepee.machineround.R
import com.phonepee.machineround.application.base.BaseFragment
import com.phonepee.machineround.home.activites.MainActivity
import com.phonepee.machineround.home.adapters.MovieListAdapter
import com.phonepee.machineround.home.adapters.MovieListCallBack
import com.phonepee.machineround.home.models.response.ResultsItem
import com.phonepee.machineround.home.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.list_fragment.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@SuppressLint("NotifyDataSetChanged")
class ListFragment : BaseFragment(),MovieListCallBack {
    /*view model*/
    private lateinit var mPlayerViewModel: MainViewModel

    /*adapter view */
    private lateinit var mMovieListAdapter: MovieListAdapter
    private var mDownloadedList = ArrayList<ResultsItem?>()

    companion object {
        private var instance = ListFragment()
        fun newInstance() = instance
    }

    init {
        setLayout(R.layout.list_fragment)
    }

    override fun afterViewCreated() {
        mPlayerViewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)
        setDetailView()
    }

    private fun setDetailView() {
        mPlayerViewModel.viewModelScope.launch {
            mPlayerViewModel.fetchMovieList()
            mPlayerViewModel.provideMovieList().collect {
                if (it != null) {
                    mDownloadedList.clear()
                    mDownloadedList.addAll(it)
                    Log.i("Data Received", mDownloadedList.toString())
                    setAdapter()
                }
            }
        }
    }

    private fun setAdapter(){
        if(!::mMovieListAdapter.isInitialized){
            mMovieListAdapter = MovieListAdapter(mDownloadedList, this)
            rvMoviesList.layoutManager=LinearLayoutManager(context)
        }
//        mMovieListAdapter.movieList.clear()
//        mMovieListAdapter.movieList.addAll(mDownloadedList)
        rvMoviesList.adapter = mMovieListAdapter
        mMovieListAdapter.notifyDataSetChanged()
    }

    override fun onMovieSelected(resultsItem: ResultsItem?) {
        (activity as? MainActivity)?.openDetailFragment(resultsItem)
    }
}