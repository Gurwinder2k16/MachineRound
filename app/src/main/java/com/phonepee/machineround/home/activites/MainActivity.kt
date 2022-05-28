package com.phonepee.machineround.home.activites

import androidx.fragment.app.Fragment
import com.phonepee.machineround.R
import com.phonepee.machineround.application.base.BaseActivity
import com.phonepee.machineround.home.fragments.DetailFragment
import com.phonepee.machineround.home.fragments.ListFragment
import com.phonepee.machineround.home.models.response.ResultsItem
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mDefaultFragment: ListFragment

    @Inject
    lateinit var mDetailFragment: DetailFragment

    init {
        setLayout(R.layout.activity_main)
    }

    override fun afterViewCreated() {
        super.afterViewCreated()
        setDefaultPlayerRoute(mDefaultFragment)
    }

    private fun setDefaultPlayerRoute(
        pFragment: Fragment,
        pAdd: Boolean = false
    ) {
        supportFragmentManager.beginTransaction().let {
            when (pAdd) {
                true -> {
                    it.add(R.id.container, pFragment)
                    it.addToBackStack(pFragment::class.java.simpleName)
                }
                false -> {
                    it.replace(R.id.container, pFragment)
                }
            }
        }.commit()
    }

    fun openDetailFragment(resultsItem: ResultsItem?){
        resultsItem?.let {
            mDetailFragment.setArguments(resultsItem = it)
            setDefaultPlayerRoute(mDetailFragment,true)
        }
    }
}