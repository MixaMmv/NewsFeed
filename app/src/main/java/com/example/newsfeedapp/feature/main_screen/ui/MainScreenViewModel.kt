package com.example.newsfeedapp.feature.main_screen.ui

import com.example.newsfeedapp.base.BaseViewModel
import com.example.newsfeedapp.base.Event
import com.example.newsfeedapp.feature.main_screen.domain.NewsInteractor

class MainScreenViewModel(private val newsInteractor: NewsInteractor) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(UIEvent.GetCurrentNews)
    }

    override fun initialViewState(): ViewState {
        return ViewState(emptyList(), true, "", false)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.OnLoadData -> {
                return previousState.copy(isLoading = true)
            }
            is DataEvent.SuccessNewsRequest -> {
                previousState.copy(
                    articleList = event.articleList,
                    isLoading = false,
                    isInErrorState = false
                )
            }
            is DataEvent.ErrorNewsRequest -> {
                return previousState.copy(
                    isLoading = false,
                    errorMessage = event.errorMessage,
                    isInErrorState = true
                )
            }
            is UIEvent.GetCurrentNews -> {
                newsInteractor.getNews().fold(
                    onError = {
                        processDataEvent(DataEvent.ErrorNewsRequest(it.localizedMessage ?: ""))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessNewsRequest(it))
                    }

                )
            }
        }
        return null
    }


}