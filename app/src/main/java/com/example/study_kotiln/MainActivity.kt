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

        //2
        val getEditText1 = {"getEditText1 : 변경한 문장은 " + editText1.text.toString() + "입니다."}

        //3
        val lamdaFun = {str : String -> "lamdaFun : 변경한 문장은 $str 입니다."} // 매개변수_이름 : 매개변수_자료형 -> 표현식 (여러 줄 일 경우 마지막 줄이 리턴)

        //4
        val lamdaRtnTest = {
            "return : this code doesn't return"
            "return : this code is returned"
        }

        //5
        val lamdaOrigin : (Int, String) -> String = {num : Int, str : String -> "return : $num : $str"} // 정석. 변수명 : (매개변수) -> 리턴형 - {매개변수명 : 자료형 -> 표현식}

        button1.setOnClickListener {
            /*
            //1
            textView1.text = setText(editText1.text.toString())

            //2
            texView1.text = getEditText1()

            //3
            texView1.text = lamdaFun(editText1.text.toString())

            //4
            textView1.text = lamdaRtnTest()

            //5
            textView1.text = lamdaOrigin(1,"this is return value")
            */
            //6 고차함수 // 서버에서 json데이터 받고 바로 가공하거나 할 경우에 사용하면 될 듯.
            textView1.text = out(sum(1,2))



            //var test_fun = operation({addition(10,20)})

            //이게 아닌데...
            //textView1.text = operation({addition(10,20)}).toString()


        }
    }

    //6
    fun out(sum : Int) : String{
        return "sum : $sum"
    }
    fun sum(n1 : Int, n2: Int)  = n1 + n2


    fun operation( cal: () -> Int){
        cal()
    }

    fun addition(n1 : Int, n2 : Int) : Int{
        return n1 + n2;
    }

    fun subtraction(n1 : Int, n2 : Int) : Int{
        return n1 - n2;
    }




    //1
    fun setText(str : String) : String{
        return "setText : 변경한 문장은 '" + str + "' 입니다."
    }
}
