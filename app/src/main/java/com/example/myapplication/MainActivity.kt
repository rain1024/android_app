package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var subjects: List<String> = listOf("iOS", "Android", "PHP")
        listview.adapter = ArrayAdapter(
             this,
            android.R.layout.simple_list_item_1,
            subjects
        )
        var dishes: ArrayList<Dish> = ArrayList()
        dishes.add(Dish("Bánh cuốn", R.drawable.dish1))
        dishes.add(Dish("Phở", R.drawable.dish2))
        dishes.add(Dish("Bún chả", R.drawable.dish3))
        dishes.add(Dish("Gỏi tôm", R.drawable.dish4))
        listview.adapter = CustomAdapter(this@MainActivity, dishes)
    }
}