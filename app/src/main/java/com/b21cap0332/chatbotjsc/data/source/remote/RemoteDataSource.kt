package com.b21cap0332.chatbotjsc.data.source.remote

class RemoteDataSource {
    companion object {
        @Volatile
        var INSTANCE: RemoteDataSource? = null
        fun getInstance(): RemoteDataSource =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: RemoteDataSource().apply { INSTANCE = this }
            }
    }

    fun getAnswer() {
        
    }
}