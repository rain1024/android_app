package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addButton.setOnClickListener {
            var a: Int = first_number.text.toString().toInt()
            var b: Int = second_number.text.toString().toInt()
            var s: Int = a + b
            result.text = s.toString()
        }

        minusButton.setOnClickListener {
            var a: Int = first_number.text.toString().toInt()
            var b: Int = second_number.text.toString().toInt()
            var s: Int = a - b
            result.text = s.toString()
        }
        multiplyButton.setOnClickListener {
            var a: Int = first_number.text.toString().toInt()
            var b: Int = second_number.text.toString().toInt()
            var s: Int = a * b
            result.text = s.toString()
        }
        divideButton.setOnClickListener {
            var a: Int = first_number.text.toString().toInt()
            var b: Int = second_number.text.toString().toInt()
            var s: Int = a / b
            result.text = s.toString()
        }
    }
}