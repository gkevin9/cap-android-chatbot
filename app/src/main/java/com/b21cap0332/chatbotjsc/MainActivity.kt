package com.b21cap0332.chatbotjsc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.b21cap0332.chatbotjsc.data.Message
import com.b21cap0332.chatbotjsc.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MessageAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MessageAdapter()
        
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]

        binding.apply {
            rvMessage.adapter = adapter
            rvMessage.layoutManager = LinearLayoutManager(this@MainActivity)

            txtQuestion.addTextChangedListener {
                if (it?.length ?: 0 > 0) {
                    binding.btnSend.visibility = View.VISIBLE
                } else {
                    binding.btnSend.visibility = View.GONE
                }
            }
        }
        
        binding.btnSend.setOnClickListener { 
            viewModel.sendMessageToApi(binding.txtQuestion.text.toString())
            val time = SimpleDateFormat("HH:mm", Locale("in", "ID")).format(Date())
            adapter.setItem(
                Message(binding.txtQuestion.text.toString(), MessageAdapter.SEND, time)
            )
            binding.txtQuestion.setText("")
        }
    }
}