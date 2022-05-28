package com.phonepee.machineround.di

import android.app.Activity
import android.app.Application
import com.phonepee.machineround.application.MyApplication
import com.phonepee.machineround.utils.network.RestApiClientConfigModule
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        FragmentModules::class,
        ViewModelModule::class,
        FragmentModuleProvider::class,
        RestApiClientConfigModule::class,
        UtilsModules::class,
        ApplicationModule::class,
        AndroidSupportInjectionModule::class
    ]
)
@Singleton
interface AppComponent {
    /*
     * We will call this builder interface from our custom Application class.
     * This will set our application object to the TripComponent.
     * So inside the TripComponent the application instance is available.
     * So this application instance can be accessed by our modules
     * such as ApiModule when needed
     *
     * */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    /*
     * This is our custom Application class
     * */
    fun inject(appController: MyApplication)
}