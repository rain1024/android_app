package com.example.myapplication

import android.content.AsyncQueryHandler
import android.content.Intent
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
        button1.setOnClickListener {
            ReadContentURL().execute("https://khoapham.vn/")
        }
    }

    inner class ReadContentURL: AsyncTask<String, Void, String>(){
        override fun doInBackground(vararg p0: String?): String {
            var content: StringBuilder = StringBuilder()
            var url: URL = URL(p0[0])
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            val inputStream: InputStream = connection.inputStream
            val reader: InputStreamReader = InputStreamReader(inputStream)
            val buffer: BufferedReader = BufferedReader(reader)
            var line: String = ""
            try {
                do {
                    line = buffer.readLine()
                    if(line != null){
                        content.append(line)
                    }
                } while (line != null)
                buffer.close()
            } catch (e: Exception) {
                Log.d("AAA", e.toString())
            }
            return content.toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_LONG).show()
        }

    }

}