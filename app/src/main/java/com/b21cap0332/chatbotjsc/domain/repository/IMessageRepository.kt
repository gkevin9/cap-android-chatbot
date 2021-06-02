package com.b21cap0332.chatbotjsc.domain.repository

import com.b21cap0332.chatbotjsc.domain.model.Message
import io.reactivex.Flowable

interface IMessageRepository {
    fun getAnswer(question: String): Flowable<Message>
}