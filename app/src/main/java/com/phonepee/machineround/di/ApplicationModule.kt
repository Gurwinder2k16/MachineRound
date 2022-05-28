package com.phonepee.machineround.di

import android.app.Activity
import com.phonepee.machineround.application.MyApplication
import com.phonepee.machineround.application.base.BaseActivity
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class ApplicationModule {


    @Inject
    fun provideCurrentActivity(application: MyApplication): BaseActivity {
        return application.mCurrentActivityTop
    }

}