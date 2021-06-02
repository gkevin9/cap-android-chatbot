package com.b21cap0332.chatbotjsc.data.source.remote

import com.google.gson.annotations.SerializedName

data class MessageResponse(
    @field:SerializedName("answer")
    val answer: String
)
