package com.b21cap0332.chatbotjsc.data

import android.util.Log
import com.b21cap0332.chatbotjsc.data.source.remote.RemoteDataSource
import com.b21cap0332.chatbotjsc.domain.model.Message
import com.b21cap0332.chatbotjsc.domain.repository.IMessageRepository
import com.b21cap0332.chatbotjsc.utils.DataMapper
import io.reactivex.Flowable

class MessageRepository(private val remote: RemoteDataSource): IMessageRepository {
    override fun getAnswer(question: String): Flowable<Message> {
        return remote.getAnswer(question).map {
            DataMapper.messageResponseToMessage(it)
        }
    }
}