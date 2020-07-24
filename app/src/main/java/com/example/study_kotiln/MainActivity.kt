package com.example.study_kotiln

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var texView1 = findViewById<TextView>(R.id.textView1)
        var editText1 = findViewById<TextView>(R.id.editText1)
        var button1 = findViewById<TextView>(R.id.button1)

        button1.setOnClickListener {
            textView1.text = setText(editText1.text.toString())
        }
    }

    fun setText(str : String) : String{
        return "변경한 문장은 '" + str + "' 입니다."
    }
}
