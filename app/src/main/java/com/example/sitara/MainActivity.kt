package com.example.sitara

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sitara.databinding.ActivityMainBinding
import com.example.sitara.databinding.ActivityPage3Binding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.imageView4.setOnClickListener {
            val intent= Intent(this,ActivityPage3Binding::class.java)
            startActivity(intent)

        }
        binding.imageView3.setOnClickListener {
            val intent= Intent(this,ActivityPage3Binding::class.java)
            startActivity(intent)

        }
    }
}