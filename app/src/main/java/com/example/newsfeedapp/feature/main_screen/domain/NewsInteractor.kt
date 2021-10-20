package com.example.newsfeedapp.feature.main_screen.domain

import com.example.newsfeedapp.attempt
import com.example.newsfeedapp.feature.main_screen.data.api.NewsRepository
import com.example.newsfeedapp.feature.main_screen.domain.model.NewsDomainModel

class NewsInteractor(val newsRepository: NewsRepository) {

    suspend fun getNews()= attempt {
          newsRepository.getNews()
    }

}