package com.charly.positive_touch.src.features.news.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.charly.positive_touch.src.features.news.domain.usecases.GetHappyNewsUseCase

class NewsViewModelFactory (
    private val getHappyNewsUseCase: GetHappyNewsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NewsViewModel(getHappyNewsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}