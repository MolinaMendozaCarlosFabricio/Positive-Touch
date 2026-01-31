package com.charly.positive_touch.src.features.news.data.repositories

import com.charly.positive_touch.BuildConfig
import com.charly.positive_touch.src.core.network.MediataskApi
import com.charly.positive_touch.src.features.news.data.datasource.remote.mapper.toDomain
import com.charly.positive_touch.src.features.news.domain.entities.News
import com.charly.positive_touch.src.features.news.domain.repositories.NewsRepository

class NewsRepositoryImpl (
    private val api: MediataskApi
): NewsRepository {
    override suspend fun getHappyNews(): List<News> {
        val response = api.getHappyNews(
            query = "good",
            lang = "en",
            max = 10,
            apiKey = BuildConfig.MEDIATASK_API_KEY
        )
        return response.data.map { it.toDomain() }
    }
}