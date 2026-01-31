package com.charly.positive_touch.src.features.news.presentation.screens

import com.charly.positive_touch.src.features.news.domain.entities.News

data class NewsUiState(
    val isLoading: Boolean = false,
    val news: List<News> = emptyList(),
    val error: String? = null,
    val isRefreshing: Boolean = false
)
