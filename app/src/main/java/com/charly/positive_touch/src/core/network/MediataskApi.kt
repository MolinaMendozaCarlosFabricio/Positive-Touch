package com.charly.positive_touch.src.core.network

import com.charly.positive_touch.src.features.news.data.datasource.remote.model.GetResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MediataskApi {
    @GET("news")
    suspend fun getHappyNews(
        @Query("keywords") query: String,
        @Query("languages") lang: String,
        @Query("limit") max: Int,
        @Query("access_key") apiKey: String
    ): GetResponse
}