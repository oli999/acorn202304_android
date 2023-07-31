package com.example.step06sharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.step06sharedpref.databinding.ActivityMainBinding;

/*
    App 에서 문자열을 영구 저장하는 방법
    (영구 저장이란 앱을 종료하고 다시 시작해도 불러올수 있는 문자열 )

    1. 파일 입출력을 이용해서 저장
    2. android 내장 data base 를 이용해서 저장  => SQLite DataBase
    3. SharedPreference 를 이용해서 저장 (느리지만 간단히 저장하고 불러 올수 있다)
       내부적으로 xml 문서를 만들어서 문자열을 저장하고 불러온다.
       저장된 문자열을 boolean, int, double, String type 으로 변환해서 불러 올수 있다.

 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //바인딩 객체의 참조값 얻어오기
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        //화면 구성하기
        setContentView(binding.getRoot());
        //저장하기 버튼을 눌렀을때
        binding.saveBtn.setOnClickListener(view -> {
            //입력한 문자열 읽어오기
            String msg=binding.editText.getText().toString();
            //어딘가에 영구 저장하기....
            SharedPreferences pref=getSharedPreferences("info",
                    Context.MODE_PRIVATE);
            //에디터 객체 얻어와서
            SharedPreferences.Editor editor=pref.edit();
            // "msg" 라는 키값으로 입력한 문자열을 저장한다.
            editor.putString("msg", msg);
            editor.commit();
            new AlertDialog.Builder(this)
                    .setTitle("알림")
                    .setMessage("저장했습니다.")
                    .setNegativeButton("확인", null)
                    .create()
                    .show();
        });
        //불러오기 버튼을 눌렀을때
        binding.readBtn.setOnClickListener(view -> {
            SharedPreferences pref=getSharedPreferences("info",
                    Context.MODE_PRIVATE);
            // .getXXX("키값", 기본값)
            String msg=pref.getString("msg", "없음");
            binding.editText.setText(msg);
        });
    }
    //MainActivity 가 최초 활성화 될때도 동작하고 비활성화(onStop()) 에 있다가
    //다시 활성화 될때도 어떠한 동작을 하고 싶으면  onStart() 메소드 안에서 하는것이 좋다.
    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(this);
        String signature=pref.getString("signature","");
        Toast.makeText(this, "당신은:"+signature, Toast.LENGTH_SHORT).show();
    }

    //옵션 메뉴를 만들기 위해서 오버라이드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //옵션 메뉴 아이템을 클릭하면 호출되는 메소드 오버라이드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //만일 Settings 를 클릭했다면
        if(item.getItemId() == R.id.setting) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}