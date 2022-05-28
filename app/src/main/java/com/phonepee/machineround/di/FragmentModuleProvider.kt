package com.phonepee.machineround.di

import com.phonepee.machineround.home.fragments.DetailFragment
import com.phonepee.machineround.home.fragments.ListFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModuleProvider {

    @Provides
    fun getDetailFragment(): DetailFragment {
        return DetailFragment.newInstance()
    }

    @Provides
    fun getListFragment(): ListFragment {
        return ListFragment.newInstance()
    }

}