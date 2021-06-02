package com.b21cap0332.chatbotjsc.data.source.remote

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("question")
    fun getAnswer(
        @Query("question") question: String,
    ): Flowable<MessageResponse>
}