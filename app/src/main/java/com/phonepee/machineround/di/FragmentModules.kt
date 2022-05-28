package com.phonepee.machineround.di

import com.phonepee.machineround.home.activites.MainActivity
import com.phonepee.machineround.home.adapters.MovieListAdapter
import com.phonepee.machineround.home.fragments.DetailFragment
import com.phonepee.machineround.home.fragments.ListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModules {

    /*common contributor*/
    @ContributesAndroidInjector
    abstract fun contributeMainActivityModule(): MainActivity


    /*fragment contributor*/
    @ContributesAndroidInjector
    abstract fun contributeToDetailFragmentModule(): DetailFragment

    @ContributesAndroidInjector
    abstract fun contributeToListFragmentModule(): ListFragment

}