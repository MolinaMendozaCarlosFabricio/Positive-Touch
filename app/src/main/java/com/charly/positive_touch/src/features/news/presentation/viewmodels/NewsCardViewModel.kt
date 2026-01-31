package com.charly.positive_touch.src.features.news.presentation.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NewsCardViewModel: ViewModel() {
    private val _expanded = MutableStateFlow(false)
    val expanded = _expanded.asStateFlow()

    fun changeExpantion(){
        _expanded.value = !_expanded.value
    }
}