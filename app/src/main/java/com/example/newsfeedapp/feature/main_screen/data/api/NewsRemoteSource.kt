package com.example.newsfeedapp.feature.main_screen.data.api

import com.example.newsfeedapp.feature.main_screen.data.api.model.NewsModel

class NewsRemoteSource (val api: NewsApi) {
    suspend fun getNews(countryName: String): NewsModel {
        return api.getNews("ru")
    }
}