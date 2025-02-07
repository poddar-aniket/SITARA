package com.example.sitara

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sitara.databinding.ActivityLoginBinding
import com.example.sitara.model.uploader
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.*
import com.google.firebase.firestore.firestore

class loginActivity : AppCompatActivity() {
   lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.textView11.setOnClickListener {
         var intent=Intent(this,signup::class.java)
         startActivity(intent)

        }
        binding.login.setOnClickListener {
            login()
        }
    }




    fun login(){
        var ide=binding.usemail.text.toString()
        var pass=binding.pass.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(ide).matches()){

            binding.usemail.setError("email not valid")
            return
        }
        if(pass.length<6){
            binding.pass.setError("Minimum 6 characters")
            return
        }
        loginwithfirebase(ide,pass)
    }

    fun loginwithfirebase(email : String , pass :String){
       FirebaseAuth.getInstance().signInWithEmailAndPassword(
            email,pass
        ).addOnSuccessListener{
            Toast.makeText(applicationContext,"login Successfully", Toast.LENGTH_SHORT).show()
            var intent=Intent(applicationContext,videoupload::class.java)
            startActivity(intent)

        }
    }
}