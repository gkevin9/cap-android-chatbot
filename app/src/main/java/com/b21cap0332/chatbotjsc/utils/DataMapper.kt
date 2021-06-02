package com.b21cap0332.chatbotjsc.utils

import com.b21cap0332.chatbotjsc.data.source.remote.MessageResponse
import com.b21cap0332.chatbotjsc.domain.model.Message
import com.b21cap0332.chatbotjsc.ui.MessageAdapter

object DataMapper {
    fun messageResponseToMessage(answer: MessageResponse): Message {
        return Message(
            text = answer.answer,
            type = MessageAdapter.RECEIVED,
            time = "00.00"
        )
    }
}