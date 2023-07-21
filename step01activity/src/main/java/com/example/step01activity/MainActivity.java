package com.example.step01activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //카운트를 셀 필드
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main.xml 문서를 전개해서 화면 구성하기
        this.setContentView(R.layout.activity_main);
    }
    //리셋 버튼을 클릭했을때 실행되는 메소드
    public void resetClicked(View v){
        count=0;
        /*
            현재 활성화 되어 있는 액티비티가 구성한 화면에서
            textView 라는 아이디를 가지고 있는 UI 의 참조값 얻어와서
            TextView type 의 a 라는 지역 변수에 담기
         */
        TextView a=findViewById(R.id.textView);
        a.setText(Integer.toString(count));
    }

    //버튼을 클릭했을때 실행되는 메소드
    public void clicked(View v){
        //필드의 값을 1 증가 시키기
        count++;
        //필드의 값을 TextView 에 출력하기
        // res/layout/activity_main.xml 문서를 전개해서  레이아웃을 구성했는데
        // 거기에서 TextView 의 참조값을 얻어와야 한다.
        TextView a=findViewById(R.id.textView);
        a.setText(Integer.toString(count));
    }
}