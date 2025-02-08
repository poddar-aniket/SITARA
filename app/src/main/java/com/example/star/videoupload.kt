package com.example.star

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.star.databinding.ActivityVideouploadBinding
//import com.example.star.databinding.ActivityVideouploadBinding


class videoupload : AppCompatActivity() {
    lateinit var binding: ActivityVideouploadBinding

    private var  viduri: Uri?=null
    lateinit var vidlaunch:ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityVideouploadBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        vidlaunch=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result->
            if(result.resultCode== RESULT_OK){
                viduri=result.data?.data
                Toast.makeText(this,"got video"+viduri.toString(),Toast.LENGTH_SHORT).show()
            }
        }
        permission()

        binding.button2.setOnClickListener {

            runOnUiThread {
                Toast.makeText(this, "Video uploaded successfully!", Toast.LENGTH_SHORT).show()

            }}
    }
    fun permission(){
        // Toast.makeText(applicationContext,"video is",Toast.LENGTH_SHORT).show()
        var readextvid : String = ""
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU){
            //  Toast.makeText(applicationContext,"if phone",Toast.LENGTH_SHORT).show()
            readextvid= Manifest.permission.READ_MEDIA_VIDEO
        }else{
            // Toast.makeText(applicationContext,"ese phone",Toast.LENGTH_SHORT).show()
            readextvid= Manifest.permission.READ_EXTERNAL_STORAGE
        }
        if(ContextCompat.checkSelfPermission(this,readextvid)==PackageManager.PERMISSION_GRANTED){
            //  Toast.makeText(applicationContext,"videopic",Toast.LENGTH_SHORT).show()
            vidpic()
        }else{
            // Toast.makeText(applicationContext,"video not pick",Toast.LENGTH_SHORT).show()
            ActivityCompat.requestPermissions(
                this,
                arrayOf(readextvid),
                100
            )
        }
    }
    private fun vidpic(){
        Toast.makeText(applicationContext,"Please pick a video",Toast.LENGTH_SHORT).show()
        var intent=Intent(Intent.ACTION_PICK,MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
        intent.type="video/*"
        vidlaunch.launch(intent)
    }
}