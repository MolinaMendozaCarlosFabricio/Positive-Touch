package com.charly.positive_touch.src.features.news.domain.di

import com.charly.positive_touch.src.core.di.AppContainer
import com.charly.positive_touch.src.features.news.domain.usecases.GetHappyNewsUseCase
import com.charly.positive_touch.src.features.news.presentation.viewmodels.NewsViewModelFactory

class NewsModule (
    private val appContainer: AppContainer
) {
    private fun provideGetHappyNewsUseCase(): GetHappyNewsUseCase {
        return GetHappyNewsUseCase(appContainer.newsRepository)
    }

    fun provideNewsViewModelFactory(): NewsViewModelFactory {
        return NewsViewModelFactory(provideGetHappyNewsUseCase())
    }
}