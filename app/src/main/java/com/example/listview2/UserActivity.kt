package com.example.listview2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listview2.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    lateinit var binding:ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name=intent.getStringExtra("name")
        val phoneNumber=intent.getStringExtra("phone")
        val imageId = intent.getIntExtra("img",R.drawable.android)

        val nameTv=binding.tvName
        val phoneTv=binding.tvPhone
        val image=binding.profileImage

        nameTv.text=name
        phoneTv.text=phoneNumber
        image.setImageResource(imageId)
    }
}