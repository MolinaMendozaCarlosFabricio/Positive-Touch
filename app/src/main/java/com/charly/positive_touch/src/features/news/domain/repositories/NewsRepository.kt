package com.charly.positive_touch.src.features.news.domain.repositories

import com.charly.positive_touch.src.features.news.domain.entities.News

interface NewsRepository {
    suspend fun getHappyNews(): List<News>
}