package com.example.star

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.star.videoupload
import com.example.star.databinding.ActivityUserdisplayBinding

class userdisplay : AppCompatActivity() {
    lateinit var binding: ActivityUserdisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityUserdisplayBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.imageView11.setOnClickListener {
            var intent=Intent(this,videoupload::class.java)
            startActivity(intent)
        }
    }
}