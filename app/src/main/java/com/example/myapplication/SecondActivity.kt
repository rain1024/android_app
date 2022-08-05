package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//        activity_secondval name = intent.getStringExtra("data")
//        val number = intent.getIntExtra("number", 0)
//        val array: IntArray = intent.getIntArrayExtra("array")!!
        val dish: Dish = intent.getSerializableExtra("data") as Dish
//        textView.text = name
//        textView.text = number.toString()
//        textView.text = array.get(0).toString()
        textView.text  = dish.name
    }
}