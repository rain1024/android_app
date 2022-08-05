package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url: String = "https://i.imgur.com/DvpvklR.png"
        val urlFail: String = "https://i.imgur.com/DvpvklR111.png1111"
        // case 1: Normal
//        Picasso.get().load(url).into(imageView);
        // case 2: With loading
//        Picasso.get()
//            .load(url)
//            .placeholder(R.drawable.image_loading)
//            .error(R.drawable.image_fail)
//            .into(imageView);
        // case 3: Loading fail
        Picasso.get()
            .load(urlFail)
            .placeholder(R.drawable.image_loading)
            .error(R.drawable.image_fail)
            .into(imageView);
    }
}