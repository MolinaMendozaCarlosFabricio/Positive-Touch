package com.charly.positive_touch.src.features.news.data.datasource.remote.model

data class GetResponse(
    val pagination: PaginationDTO,
    val data: List<NewsDTO>,
)
