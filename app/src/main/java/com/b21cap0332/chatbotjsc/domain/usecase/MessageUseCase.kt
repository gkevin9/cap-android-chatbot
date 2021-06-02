package com.b21cap0332.chatbotjsc.domain.usecase

import com.b21cap0332.chatbotjsc.domain.model.Message
import io.reactivex.Flowable

interface MessageUseCase {
    fun getAnswer(question: String): Flowable<Message>
}