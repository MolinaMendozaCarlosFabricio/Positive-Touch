package com.charly.positive_touch.src.features.news.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.charly.positive_touch.R
import com.charly.positive_touch.src.features.news.presentation.components.NewsCard
import com.charly.positive_touch.src.features.news.presentation.viewmodels.NewsCardViewModel
import com.charly.positive_touch.src.features.news.presentation.viewmodels.NewsViewModel
import com.charly.positive_touch.src.features.news.presentation.viewmodels.NewsViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    factory: NewsViewModelFactory
) {
    val viewModel: NewsViewModel = viewModel(factory = factory)
    val uiState by viewModel.uiState.collectAsState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF2F7C9))
    ) {

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFC107)) // amarillo fuerte
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.positive_touch_logo),
                contentDescription = "Positive Touch",
                modifier = Modifier.height(48.dp)
            )
        }

        Text("Items: ${uiState.news.size}")

        LazyColumn (
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(uiState.news) { item ->
                NewsCard(
                    news = item,
                    viewModel = NewsCardViewModel()
                )
            }
        }
    }
}
