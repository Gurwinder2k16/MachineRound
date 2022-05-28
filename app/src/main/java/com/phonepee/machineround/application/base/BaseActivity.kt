package com.phonepee.machineround.application.base

import android.app.Activity
import android.os.Bundle
import com.phonepee.machineround.di.factory.ViewModelFactory
import com.phonepee.machineround.utils.dialog.ProgressBarDialog
import com.phonepee.machineround.utils.imageutils.ImageUtilsModules
import dagger.android.support.DaggerAppCompatActivity
import retrofit2.Retrofit
import javax.inject.Inject

open class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var mImageUtilsModules: ImageUtilsModules

    @Inject
    lateinit var mProgressBarDialog: ProgressBarDialog

    private var layout: Int = -1

    fun setLayout(layout: Int) {
        this.layout = layout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        if (savedInstanceState == null) {
            afterViewCreated()
        }
    }

    open fun afterViewCreated() {}

}