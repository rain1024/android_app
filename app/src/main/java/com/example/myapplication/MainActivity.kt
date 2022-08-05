package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://api.publicapis.org/entries"
        ReadJSON().execute(url)
    }

    inner class ReadJSON: AsyncTask<String, Void, String>(){
        override fun doInBackground(vararg p0: String?): String {
            var text = ""
            val url: URL = URL(p0[0])
            val connect: HttpURLConnection = url.openConnection() as HttpURLConnection
            try {
                text = connect.inputStream.bufferedReader().readText()
            } finally {
                connect.disconnect()
            }
            return text
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val data: JSONObject = JSONObject(result)
            val item = data.getInt("count")
            val s = data.getJSONArray("entries").getJSONObject(0).getString("API")
            Toast.makeText(applicationContext, s, Toast.LENGTH_LONG).show()
        }
    }
}