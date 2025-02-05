package com.example.sitara

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sitara.databinding.ActivityPage2Binding
import com.example.sitara.databinding.ActivityPage4Binding

class page2 : AppCompatActivity() {
   lateinit var binding: ActivityPage2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityPage2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.textView8.setOnClickListener {
            var intent = Intent(this,page3::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            var itw= Intent(this,ActivityPage4Binding::class.java)
            startActivity(itw)
        }
    }
}