package com.example.sitara

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sitara.databinding.ActivityPage4Binding

class page4 : AppCompatActivity() {
    lateinit var binding: ActivityPage4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
       binding=ActivityPage4Binding.inflate(layoutInflater)

    }
}