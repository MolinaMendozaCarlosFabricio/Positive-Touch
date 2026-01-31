package com.charly.positive_touch.src.features.news.data.datasource.remote.model

data class PaginationDTO(
    var limit: Int,
    var offset: Int,
    var count: Int,
    var total: Int,
)
