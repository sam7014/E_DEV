package com.example.study_kotiln

import android.content.Intent
import android.os.AsyncTask
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


            //7
            val plus : (Int,Int) -> Int = {x,y -> x + y}
            val minus : (Int,Int) -> Int = {x,y -> x - y}

            textView1.text = operation(plus,11,22).toString()
            textView1.text = operation(minus,100,1).toString()

            // 클래스, 데이터 클래스, 네스티드 클래스 공부




            var temp = StockInfo("A00","메인창고","KMASDFA-A01","쿠션","01",20000,10)
            var temp_list = mutableListOf<StockInfo>()
            temp_list.add(temp)



            //

            var intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("keyword","쉐이딩")
            startActivity(intent)





            var asyncTest = object : AsyncTask<Void,Void,String>(){
                // 백그라운드에서 값이 연산되는 부분
                override fun doInBackground(vararg params: Void?): String {
                    return "test"
                }
                // 중간 값이 출력되는 부분
                override fun onProgressUpdate(vararg values: Void?) {
                    super.onProgressUpdate(*values)
                }
                // 최종 값이 출력되는 부분
                override fun onPreExecute() {
                    super.onPreExecute()
                }
            }
        }
    }

    //6
    fun out(sum : Int) : String{
        return "sum : $sum"
    }
    fun sum(n1 : Int, n2: Int)  = n1 + n2


    //7
    fun operation( cal: (Int, Int) -> Int, x:Int, y:Int) : Int = cal(x,y)




    //1
    fun setText(str : String) : String{
        return "setText : 변경한 문장은 '" + str + "' 입니다."
    }
}
