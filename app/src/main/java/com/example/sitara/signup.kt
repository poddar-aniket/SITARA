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
        binding.textView8.setOnClickListener {
            var i=Intent(this,loginActivity::class.java)
            startActivity(i)
        }
      binding.signup.setOnClickListener {
          signup()
      }
    }

   fun signup(){
        var email=binding.usemail.text.toString()
        var password=binding.pass.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.usemail.setError("email not valid")
            return
        }
        if(password.length<6){
            binding.pass.setError("Minimum 6 characters")
            return
        }
        signupwithfirebase(email,password)

    }
    fun signupwithfirebase(themail : String , thepass :String){
        Toast.makeText(applicationContext,"aagaya",Toast.LENGTH_SHORT).show()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
            themail,thepass
        ).addOnSuccessListener{
            Toast.makeText(applicationContext,"Success",Toast.LENGTH_SHORT).show()
         it.user.let{ user ->
             if(user!=null) {
                 val usermod = uploader(user.uid, themail)
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
