package com.phonepee.machineround.application

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.phonepee.machineround.application.base.BaseActivity
import com.phonepee.machineround.di.DaggerAppComponent
import dagger.android.*
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    lateinit var mCurrentActivityTop: BaseActivity

    private fun setActivity(pActivity: BaseActivity) {
        mCurrentActivityTop = pActivity
    }

    override fun onCreate() {
        super.onCreate()
        setDaggerComponent()
    }

    private fun setDaggerComponent() {
        DaggerAppComponent.builder().application(this).build().inject(this)
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                setActivity(activity as BaseActivity)
                try {
                    AndroidInjection.inject(activity)
                } catch (e: Exception) {
                    Log.e("ex", e.localizedMessage!!)
                }
            }

            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {
                setActivity(activity as BaseActivity)
            }

            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })
    }

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}