package com.charly.positive_touch.src.features.news.domain.usecases

import com.charly.positive_touch.src.features.news.domain.entities.News
import com.charly.positive_touch.src.features.news.domain.repositories.NewsRepository

class GetHappyNewsUseCase (
    private val repo: NewsRepository
) {
    suspend operator fun invoke(): Result<List<News>> {
        return try {
            val news = repo.getHappyNews()

            if (news.isEmpty())
                Result.failure(Exception("No se encontraron noticias"))
            else
                Result.success(news)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}