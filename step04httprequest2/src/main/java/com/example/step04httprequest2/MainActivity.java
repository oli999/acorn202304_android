package com.example.step04httprequest2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements Util.RequestListener{
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        EditText inputUrl=findViewById(R.id.inputUrl);
        //요청 버튼을 클릭했을때 동작할 준비
        Button requestBtn=findViewById(R.id.requestBtn);
        requestBtn.setOnClickListener(view -> {
            //1. 입력한 url 주소를 읽어와서
            String url=inputUrl.getText().toString();
            Util.sendGetRequest(999, url, null, this);
        });
    }

    @Override
    public void onSuccess(int requestId, Map<String, Object> result) {
        if(requestId == 999){
            // Map 에 data 라는 키값으로 담긴 String type 을 읽어온다.
            String data=(String)result.get("data");
            //결과 문자열을 EditText 에 출력하기
            editText.setText(data);
        }
    }

    @Override
    public void onFail(int requestId, Map<String, Object> result) {
        //에러메세지를 읽어와서 EditText 에 출력하기
        String data=(String)result.get("data");
        editText.setText(data);
    }
}