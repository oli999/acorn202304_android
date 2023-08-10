package com.example.step08gameview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //무음 모드인지 여부( 초기값 false 부여)
    var isMute=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val startBtn: Button = findViewById(R.id.startBtn)
        startBtn.setOnClickListener {
            /*
                java 에서 사용했던  클래스 type value 얻어오는 방법
                1. java =>  클래스명.class
                2. kotlin => 클래스명::class.java
             */
            val intent = Intent(this, GameActivity::class.java)
            // Intent 객체에 isMute 라는 키값으로 boolean type 담기
            intent.putExtra("isMute", isMute)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //res/menu/menu_option.xml 문서를 전개해서 메뉴 구성하기
        menuInflater.inflate(R.menu.menu_option, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //옵션 메뉴를 선택하면 호출되는 메소드
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //선택한 옵션의 id 값을 읽어와서 분기한다.
        when(item.itemId){
            R.id.off -> isMute=true
            R.id.on -> isMute=false
        }
        return super.onOptionsItemSelected(item)
    }
}







