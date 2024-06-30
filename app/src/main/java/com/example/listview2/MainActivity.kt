package com.example.listview2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listview2.databinding.ActivityMainBinding
import com.example.listview2.databinding.ActivityUserBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var userArrayList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val name = arrayOf("Saumya", "Prastuti", "Ankit", "Pradeep", "Aman")
        val lastMsg = arrayOf("Hey wssup", "I am fine", "Good", "Awesome", "cool")
        val lastMsgTime = arrayOf("6:25AM", "7:30PM", "5:00PM", "6:25AM", "7:30PM")
        val phoneNumber =
            arrayOf("9827825423", "7856432678", "8976432091", "8765139087", "7451678910")
        val imgId =
            intArrayOf(R.drawable.a1, R.drawable.b1, R.drawable.c1, R.drawable.d1, R.drawable.e1)

        userArrayList = ArrayList()

        for (eachIndex in name.indices) {
            val user = User(
                name[eachIndex],
                lastMsg[eachIndex],
                lastMsgTime[eachIndex],
                phoneNumber[eachIndex],
                imgId[eachIndex]
            )
            userArrayList.add(user)
        }
        val listview = binding.listView
        listview.isClickable = true
        listview.adapter = MyAdapter(this, userArrayList)

        listview.setOnItemClickListener { parent, view, position, id ->
            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imgID = imgId[position]

            val i = Intent(this, UserActivity::class.java)

            i.putExtra("name", userName)
            i.putExtra("phone", userPhone)
            i.putExtra("img", imgID)
            startActivity(i)
        }
    }
}