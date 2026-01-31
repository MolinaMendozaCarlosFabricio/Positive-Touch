package com.charly.positive_touch.src.features.news.data.datasource.remote.mapper

import com.charly.positive_touch.src.features.news.data.datasource.remote.model.NewsDTO
import com.charly.positive_touch.src.features.news.domain.entities.News

fun NewsDTO.toDomain(): News {
    return News(
        author = author ?: "Unknown",
        title = title ?: "",
        description = description ?: "",
        ref = url ?: "",
        source = source ?: "",
        image_url = image ?: "",
        category = category ?: "",
        language = language ?: "",
        country = country ?: "",
        date = published_at ?: "",
    )
}
