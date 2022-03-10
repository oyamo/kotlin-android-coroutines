package com.oyamo.kotlin_android_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oyamo.kotlin_android_coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val scope = CoroutineScope(Dispatchers.Default)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding.btnCount) {
            binding.btnCount.setOnClickListener {
                runBlocking {
                    scope.launch {
                        for (i in 0..10) {
                            this@with.text = "$i"
                            delay(200)
                        }
                    }
                }
            }
        }
    }
}