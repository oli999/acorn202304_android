package com.example.step08customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //MyView 객체를 생성해서 전달하기
        //setContentView(MyView(this))

        // layout xml 문서를 이용해서 MyView 객체를사용하려면
        // Context 와 AttributeSet 객체를 인자로 전달받는 생성자가
        // 존재 해야 한다.
        setContentView(R.layout.activity_main)

    }
}