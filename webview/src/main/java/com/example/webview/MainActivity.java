package com.example.webview;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView=findViewById(R.id.webView);
        //WebView 설정 객체 얻어오기
        WebSettings ws=webView.getSettings();
        //javascript 해석가능하도록 설정
        ws.setJavaScriptEnabled(true);
        ws.setDomStorageEnabled(true);
        //WebView 클라이언트 객체를 생성해서 넣어주기
        webView.setWebViewClient(new WebViewClient(){
            //재정의 하고 싶은 메소드가 있으면 여기서 해준다.
        });

        //아래의 MyWebViewClient 클래스로 생성한 객체를 전달한다.
        webView.setWebChromeClient(new WebChromeClient());

        webView.loadUrl("http://bookmate.life/main");

    }

}