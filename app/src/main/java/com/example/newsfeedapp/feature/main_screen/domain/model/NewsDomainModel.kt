package com.example.newsfeedapp.feature.main_screen.domain.model

class NewsDomainModel(

    val author: String,
    val title: String,
    val urlToImage: String,
    val content: String,
    val source: NewsDomainSourceModel

) {
}