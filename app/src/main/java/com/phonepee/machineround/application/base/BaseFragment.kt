package com.phonepee.machineround.application.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.phonepee.machineround.di.factory.ViewModelFactory
import com.phonepee.machineround.utils.dialog.ProgressBarDialog
import com.phonepee.machineround.utils.imageutils.ImageUtilsModules
import dagger.android.support.DaggerFragment
import retrofit2.Retrofit
import javax.inject.Inject

@SuppressLint("SupportAnnotationUsage")
open class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var mNetworkService: Retrofit

    @Inject
    lateinit var mImageUtilsModules: ImageUtilsModules

    @Inject
    lateinit var mProgressBarDialog: ProgressBarDialog

    private var layout: Int = -1

    fun setLayout(layout: Int) {
        this.layout = layout
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        afterViewCreated()
    }

    open fun afterViewCreated() {}
}