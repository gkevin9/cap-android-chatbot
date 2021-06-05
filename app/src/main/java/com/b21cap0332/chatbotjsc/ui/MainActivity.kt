package com.b21cap0332.chatbotjsc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.b21cap0332.chatbotjsc.domain.model.Message
import com.b21cap0332.chatbotjsc.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: MessageAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MessageAdapter()

        binding.apply {
            rvMessage.adapter = adapter
            val layoutManager = LinearLayoutManager(this@MainActivity)
            layoutManager.stackFromEnd = true
            rvMessage.layoutManager = layoutManager

            txtQuestion.addTextChangedListener {
                if (it?.length ?: 0 > 0) {
                    binding.btnSend.visibility = View.VISIBLE
                } else {
                    binding.btnSend.visibility = View.GONE
                }
            }
        }
        
        binding.btnSend.setOnClickListener {
            val text = binding.txtQuestion.text.toString()
            viewModel.setMessage(text)
            val time = SimpleDateFormat("HH:mm", Locale("in", "ID")).format(Date())
            adapter.addItem(Message(text, MessageAdapter.SEND, time))
            binding.txtQuestion.setText("")

            viewModel.sendMessageToApi()
        }

        viewModel.sendMessageToApi().observe(this, {
            if (it.text != "no") {
                adapter.addItem(it)
            }
        })
    }
}