package com.example.newsfeedapp.feature.main_screen.data.api

import com.example.newsfeedapp.feature.main_screen.data.api.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=ru&apiKey=9f72ffef99474e5bbbd75f6c506c786a


interface NewsApi {
    @GET("v2/top-headlines")
    @Headers("X-Api-Key: 9f72ffef99474e5bbbd75f6c506c786a")
    suspend fun getNews(
        @Query("country") countryName: String = "ru",
    ): NewsModel
}