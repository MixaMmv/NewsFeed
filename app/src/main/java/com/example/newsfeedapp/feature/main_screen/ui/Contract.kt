package com.example.newsfeedapp.feature.main_screen.ui

import com.example.newsfeedapp.base.Event
import com.example.newsfeedapp.feature.main_screen.data.api.model.NewsModel
import com.example.newsfeedapp.feature.main_screen.domain.model.NewsDomainModel

data class ViewState(
    val articleList: List<NewsDomainModel>,
    val isLoading: Boolean,
    val errorMessage: String?,
    val isInErrorState: Boolean
)

sealed class UIEvent(): Event {
    object GetCurrentNews: UIEvent()
    class OnArticleClick: UIEvent()
}

sealed class DataEvent(): Event {
    object OnLoadData: DataEvent()
    data class SuccessNewsRequest(val articleList: List<NewsDomainModel>): DataEvent()
    data class ErrorNewsRequest(val errorMessage: String): DataEvent()
}