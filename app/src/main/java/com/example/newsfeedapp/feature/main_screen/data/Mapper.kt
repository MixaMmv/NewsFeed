package com.example.newsfeedapp.feature.main_screen.data

import com.example.newsfeedapp.feature.main_screen.data.api.model.NewsArticlesModel
import com.example.newsfeedapp.feature.main_screen.data.api.model.NewsSourceModel
import com.example.newsfeedapp.feature.main_screen.domain.model.NewsDomainModel
import com.example.newsfeedapp.feature.main_screen.domain.model.NewsDomainSourceModel

fun NewsSourceModel.toDomain() = NewsDomainSourceModel(
    name = name,
    id = id
)

fun NewsArticlesModel.toDomain() = NewsDomainModel(
    author = author?:"null",
    title = title?:"null",
    urlToImage = urlToImage?:"null",
    content = content?:"null",
    source = source.toDomain()
)

