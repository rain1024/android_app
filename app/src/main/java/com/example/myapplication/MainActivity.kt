package com.example.myapplication

import android.content.AsyncQueryHandler
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.loader.content.AsyncTaskLoader
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoadImage().execute("https://cdn.pixabay.com/photo/2021/08/25/20/42/field-6574455__340.jpg")
    }

    inner class LoadImage: AsyncTask<String, Void, Bitmap>(){
        override fun doInBackground(vararg p0: String?): Bitmap {
            val url = URL(p0[0])
            val inputStream = url.openConnection().getInputStream()
            val bitmap:Bitmap = BitmapFactory.decodeStream(inputStream)
            return bitmap
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            imageView.setImageBitmap(result)
        }

    }

}