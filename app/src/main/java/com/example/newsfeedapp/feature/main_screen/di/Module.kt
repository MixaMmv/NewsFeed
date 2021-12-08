package com.example.newsfeedapp.feature.main_screen.di

import com.example.newsfeedapp.feature.main_screen.ui.MainScreenViewModel
import com.example.newsfeedapp.feature.main_screen.data.api.NewsApi
import com.example.newsfeedapp.feature.main_screen.data.api.NewsRemoteSource
import com.example.newsfeedapp.feature.main_screen.data.api.NewsRepository
import com.example.newsfeedapp.feature.main_screen.data.api.NewsRepositoryImpl
import com.example.newsfeedapp.feature.main_screen.domain.NewsInteractor
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://newsapi.org/v2/top-headlines?country=ru&apiKey=9f72ffef99474e5bbbd75f6c506c786a

const val BASE_URL = "https://newsapi.org/"

val mainScreenModule = module {


    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<NewsApi> {
        get<Retrofit>().create(NewsApi::class.java)
    }

    single<NewsRemoteSource> {
        NewsRemoteSource(get<NewsApi>())
    }

    single<NewsRepository> {
        NewsRepositoryImpl(get<NewsRemoteSource>())
    }

    single<NewsInteractor> {
        NewsInteractor(get<NewsRepository>())
    }

    viewModel {
        MainScreenViewModel(get<NewsInteractor>())
    }


}