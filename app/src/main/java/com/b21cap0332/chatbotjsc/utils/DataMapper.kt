package com.b21cap0332.chatbotjsc.utils

import com.b21cap0332.chatbotjsc.data.source.remote.MessageResponse
import com.b21cap0332.chatbotjsc.domain.model.Message
import com.b21cap0332.chatbotjsc.ui.MessageAdapter
import java.text.SimpleDateFormat
import java.util.*

object DataMapper {
    fun messageResponseToMessage(answer: MessageResponse): Message {
        return Message(
            text = answer.answer,
            type = MessageAdapter.RECEIVED,
            time = SimpleDateFormat("HH:mm", Locale("in", "ID")).format(Date())
        )
    }
}