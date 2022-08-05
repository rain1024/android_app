package com.example.myapplication

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener {
            Task().execute()
        }
    }

    inner class Task : AsyncTask<Void, String, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            textView2.text = "Pre Execute \n"
        }
        override fun doInBackground(vararg p0: Void?): String {
            Log.d("AA", "Hello")
            for(task in 1..5){
                publishProgress("Doing $task\n")
            }
            return "Done"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            textView2.append(result)
        }

        override fun onProgressUpdate(vararg values: String?) {
            super.onProgressUpdate(*values)
            textView2.append(values[0])
        }

    }
}