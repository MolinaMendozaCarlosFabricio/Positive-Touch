package com.charly.positive_touch.src.core.di

import com.charly.positive_touch.BuildConfig
import android.content.Context
import com.charly.positive_touch.src.core.network.MediataskApi
import com.charly.positive_touch.src.features.news.data.repositories.NewsRepositoryImpl
import com.charly.positive_touch.src.features.news.domain.repositories.NewsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mediataskApi: MediataskApi by lazy {
        retrofit.create(MediataskApi::class.java)
    }

    val newsRepository: NewsRepository by lazy {
        NewsRepositoryImpl(mediataskApi)
    }
}