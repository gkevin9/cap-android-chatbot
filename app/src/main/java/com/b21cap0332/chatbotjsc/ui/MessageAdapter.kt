package com.b21cap0332.chatbotjsc.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.b21cap0332.chatbotjsc.domain.model.Message
import com.b21cap0332.chatbotjsc.databinding.BubbleReceivedBinding
import com.b21cap0332.chatbotjsc.databinding.BubbleSendBinding

class MessageAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listMassage = ArrayList<Message>()

    fun addItem(message: Message) {
        listMassage.add(message)
        notifyDataSetChanged()
    }

    class MessageSendHolder(val binding: BubbleSendBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.txtSendMessage.text = message.text
            binding.txtTime.text = message.time
        }
    }

    class MessageReceivedHolder(val binding: BubbleReceivedBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.txtSendMessage.text = message.text
            binding.txtTimeReceived.text = message.time
        }
    }

    override fun getItemCount(): Int {
        return listMassage.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            SEND -> (holder as MessageSendHolder).bind(listMassage[position])
            RECEIVED -> (holder as MessageReceivedHolder).bind(listMassage[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            SEND -> {
                val binding = BubbleSendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MessageSendHolder(binding)
            }
            RECEIVED -> {
                val binding = BubbleReceivedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MessageReceivedHolder(binding)
            }
            else -> {
                Log.e("MessageAdapter", "Error")
                val binding = BubbleSendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MessageSendHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return listMassage[position].type
    }

    companion object {
        const val SEND = 1
        const val RECEIVED = 2
    }
}