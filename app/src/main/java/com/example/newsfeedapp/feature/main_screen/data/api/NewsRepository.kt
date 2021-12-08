package com.example.newsfeedapp.feature.main_screen.data.api

import com.example.newsfeedapp.feature.main_screen.domain.model.NewsDomainModel

interface NewsRepository {
    suspend fun getNews(): List<NewsDomainModel>
}