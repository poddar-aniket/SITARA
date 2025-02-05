package com.example.sitara

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sitara.databinding.ActivitySignupBinding
import com.example.sitara.model.uploader
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class signup : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.textView9.setOnClickListener {
            var i=Intent(this,loginActivity::class.java)
            startActivity(i)
        }
      binding.button.setOnClickListener {
          signup()
      }
    }

   fun signup(){
        var email=binding.emailinpt.text.toString()
        var pass=binding.passwordinpt.text.toString()
        var use=binding.user.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailinpt.setError("email not valid")
            return
        }
        if(pass.length<6){
            binding.passwordinpt.setError("Minimum 6 characters")
            return
        }
        signupwithfirebase(email,pass,use)

    }
    fun signupwithfirebase(email : String , pass :String,usname:String){
        Toast.makeText(applicationContext,"aagaya",Toast.LENGTH_SHORT).show()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
            email,pass
        ).addOnSuccessListener{
            Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
         it.user.let{ user ->
             if(user!=null) {
                 val usermod = uploader(user.uid, email, usname)
                 Firebase.firestore.collection("users")
                     .document(user.uid)
                     .set(usermod).addOnSuccessListener {
                         Toast.makeText(applicationContext, "Account created successfully", Toast.LENGTH_LONG).show()
                     }
             }
         }
        }
    }
}
