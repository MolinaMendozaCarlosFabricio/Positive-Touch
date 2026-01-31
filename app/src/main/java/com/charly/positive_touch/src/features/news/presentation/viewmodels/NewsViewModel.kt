package com.charly.positive_touch.src.features.news.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charly.positive_touch.src.features.news.domain.usecases.GetHappyNewsUseCase
import com.charly.positive_touch.src.features.news.presentation.screens.NewsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel(
    private val getHappyNewsUseCase: GetHappyNewsUseCase
): ViewModel() {
    private val _uiState = MutableStateFlow(NewsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadNews()
    }

    private fun loadNews() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            val result = getHappyNewsUseCase()
            _uiState.update { currentState ->
                result.fold(
                    onSuccess = { list ->
                        currentState.copy(isLoading = false, news = list)
                    },
                    onFailure = { error ->
                        currentState.copy(isLoading = false, error = error.message)
                    }
                )
            }
        }
    }
}