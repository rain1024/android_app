package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            var intent: Intent = Intent(applicationContext, SecondActivity::class.java)
//            intent.putExtra("data", "my name")
//            intent.putExtra("number", 1)
            val arrayNumber: IntArray = intArrayOf(10, 20, 30, 40)
            val dish: Dish = Dish("bread", 0)
//            intent.putExtra("array", arrayNumber)
            intent.putExtra("data", dish)
            startActivity(intent)
        }
    }
}