package com.b21cap0332.chatbotjsc.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.b21cap0332.chatbotjsc.domain.model.Message
import com.b21cap0332.chatbotjsc.domain.usecase.MessageUseCase
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel(private val useCase: MessageUseCase): ViewModel() {

    private var message = ""

    fun sendMessageToApi(): LiveData<Message> {
        return LiveDataReactiveStreams.fromPublisher(useCase.getAnswer(message))
    }

    fun setMessage(message: String) {
        this.message = message
    }

}