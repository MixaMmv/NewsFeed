package com.example.newsfeedapp.feature.main_screen.data.api

import com.example.newsfeedapp.feature.main_screen.data.toDomain
import com.example.newsfeedapp.feature.main_screen.domain.model.NewsDomainModel

class NewsRepositoryImpl(private val source: NewsRemoteSource): NewsRepository {
    override suspend fun getNews(): List<NewsDomainModel> {
        return source.getNews("").listArticlesModel.map { it.toDomain()}
    }
}