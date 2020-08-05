package com.example.study_kotiln

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class ResultActivity : AppCompatActivity() {

    lateinit var url: URL
    lateinit var strURL: URL
    lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        println(intent.getStringExtra("keyword"))

        //var intent = intent // 그냥 바로 인텐트 사용하면 되는 듯
        val keyword = intent.getStringExtra("keyword")

        var async = object : AsyncTask<Void,Void,Void>(){
            override fun onPreExecute() {
                super.onPreExecute()
                url = URL("https://testURL/api/intranet/GetQTY?keyword=" + keyword)
            }

            override fun doInBackground(vararg params: Void?): Void {
                var conn = url.openConnection() as HttpURLConnection
                conn.requestMethod = "GET"
                conn.doInput = true
                conn.useCaches = false
                conn.defaultUseCaches = false

                var strCookie = conn.getHeaderField("Set-Cookie")

                val resCode = conn.responseCode
                val resMessage = conn.responseMessage

                val inputStream = conn.inputStream as InputStream
                val isReader : InputStreamReader


                val builder : StringBuilder
                //val reader : BufferedReader()


            }

            override fun onProgressUpdate(vararg values: Void?) {
                super.onProgressUpdate(*values)
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
            }
        }

    }
}