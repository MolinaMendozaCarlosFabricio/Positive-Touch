package com.charly.positive_touch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import com.charly.positive_touch.src.core.di.AppContainer
import com.charly.positive_touch.src.features.news.domain.di.NewsModule
import com.charly.positive_touch.src.features.news.presentation.screens.NewsScreen
import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    lateinit var appContainer: AppContainer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContainer = AppContainer(this)
        val newsModule = NewsModule(appContainer)
        enableEdgeToEdge()
        setContent {
            AppTheme() {
                NewsScreen(newsModule.provideNewsViewModelFactory())
            }
        }
    }
}