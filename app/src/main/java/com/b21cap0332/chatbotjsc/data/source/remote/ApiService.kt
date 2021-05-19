package com.b21cap0332.chatbotjsc.data.source.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("something/{question}")
    fun getAnswer(
        @Path("question") question: String,
    )
}