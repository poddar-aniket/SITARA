package com.example.sitara

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sitara.databinding.ActivityPage3Binding
import com.example.sitara.databinding.ActivityPage4Binding

class page3 : AppCompatActivity() {
    lateinit var binding: ActivityPage3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityPage3Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.textView11.setOnClickListener {
            var intent=Intent(this,page2::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            var i = Intent(this,ActivityPage4Binding::class.java)
            startActivity(i)
        }

    }
}