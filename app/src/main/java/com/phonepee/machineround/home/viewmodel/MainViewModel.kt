package com.phonepee.machineround.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.phonepee.machineround.home.models.response.ResultsItem
import com.phonepee.machineround.home.networkapis.HomeNetworkApis
import com.phonepee.machineround.utils.network.NetworkConstants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

class MainViewModel @Inject constructor(var pApplication: Application) : AndroidViewModel(pApplication) {

    @Inject
    lateinit var mNetworkService: Retrofit

    private var movieList = MutableStateFlow<List<ResultsItem?>?>(null)

    fun provideMovieList(): StateFlow<List<ResultsItem?>?> = movieList

    fun fetchMovieList() {
        viewModelScope.launch {
            val listOfMovies =
                mNetworkService.create(HomeNetworkApis::class.java).doGetListOfMovies(
                    apiKey = NetworkConstants.API_KEY,
                    language = NetworkConstants.API_LANG,
                    page = "1"
                )
            if(listOfMovies?.isSuccessful == true){
                movieList.value = listOfMovies.body()?.results
            } else {
                movieList.value = null
            }
        }
    }

}