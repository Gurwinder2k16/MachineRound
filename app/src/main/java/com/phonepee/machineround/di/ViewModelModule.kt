package com.phonepee.machineround.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.phonepee.machineround.di.bindkey.ViewModelKey
import com.phonepee.machineround.di.factory.ViewModelFactory
import com.phonepee.machineround.home.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the  MainViewModel.class as key,
     * and a Provider that will build a MainViewModel
     * object.
     *
     * */

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    protected abstract fun bindMainViewModel(moviesListViewModel: MainViewModel): ViewModel

}