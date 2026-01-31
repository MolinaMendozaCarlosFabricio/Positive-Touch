package com.charly.positive_touch.src.features.news.domain.entities

data class News(
    val author: String,
    val title: String,
    val description: String,
    val ref: String,
    val source: String,
    val image_url: String,
    val category: String,
    val language: String,
    val country: String,
    val date: String,
)
