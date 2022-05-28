package com.phonepee.machineround.home.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.phonepee.machineround.R
import com.phonepee.machineround.application.base.BaseFragment
import com.phonepee.machineround.home.models.response.ResultsItem
import com.phonepee.machineround.home.viewmodel.MainViewModel

@SuppressLint("NotifyDataSetChanged")
class DetailFragment : BaseFragment() {

    private lateinit var mPlayerViewModel: MainViewModel

    companion object {
        private var instance = DetailFragment()
        fun newInstance() = instance
    }

    init {
        setLayout(R.layout.detail_fragment)
    }

    override fun afterViewCreated() {
        mPlayerViewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainViewModel::class.java)
        setDetailView()
    }

    private fun setDetailView() {

    }

    fun setArguments(resultsItem: ResultsItem) {
        if (arguments == null) {
            arguments = Bundle()
        }
        arguments?.putSerializable(ResultsItem::class.java.simpleName, resultsItem)
    }

}