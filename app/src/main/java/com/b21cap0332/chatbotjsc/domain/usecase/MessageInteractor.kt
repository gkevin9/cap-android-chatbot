package com.b21cap0332.chatbotjsc.domain.usecase

import com.b21cap0332.chatbotjsc.domain.model.Message
import com.b21cap0332.chatbotjsc.domain.repository.IMessageRepository
import io.reactivex.Flowable

class MessageInteractor(private val repository: IMessageRepository): MessageUseCase {
    override fun getAnswer(question: String): Flowable<Message> {
        return repository.getAnswer(question)
    }
}