package com.example.step01activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //이동 버튼의 참조값 얻어오기
        Button moveBtn=findViewById(R.id.moveBtn);
        //버튼을 눌렀을때 동작하기 위한 리스너 등록
        moveBtn.setOnClickListener(this);

//        View.OnClickListener listener=new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//            }
//        };
//        moveBtn.setOnClickListener(listener);

//        moveBtn.setOnClickListener(view->{
//            //SubActivity 를 활성화 시키겠다는 의도(Intent) 객체 생성하기
//            Intent intent=new Intent(this, SubActivity.class);
//            //startActivity() 메소드를 호출하면서 Intent 객체를 전달하기
//            startActivity(intent);
//        });
    }

    @Override
    public void onClick(View view) {
        //SubActivity 를 활성화 시키겠다는 의도(Intent) 객체 생성하기
        Intent intent=new Intent(this, SubActivity.class);
        //startActivity() 메소드를 호출하면서 Intent 객체를 전달하기
        startActivity(intent);
    }
}














