package com.phonepee.machineround.home.networkapis

import com.phonepee.machineround.home.models.response.FetchMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface HomeNetworkApis {

    @GET("movie/popular?")
   suspend fun doGetListOfMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String,
    ): Response<FetchMoviesResponse?>?
}