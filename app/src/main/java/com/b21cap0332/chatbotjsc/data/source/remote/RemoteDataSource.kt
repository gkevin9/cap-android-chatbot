package com.b21cap0332.chatbotjsc.data.source.remote

import android.util.Log
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

class RemoteDataSource(private val api: ApiService) {
    private val result = PublishSubject.create<MessageResponse>()

    fun getAnswer(question: String): Flowable<MessageResponse> {

        val client = api.getAnswer(question)
        client.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                result.onNext(it)
            }, {
                Log.e("RemoteDataSource", it.toString())
            })

        return result.toFlowable(BackpressureStrategy.BUFFER)
    }
}