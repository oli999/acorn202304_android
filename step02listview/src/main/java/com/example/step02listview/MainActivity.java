package com.example.step02listview;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    //필드 선언
    List<String> names;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/layout/activity_main.xml 문서를 전개해서 화면 구성!
        setContentView(R.layout.activity_main);

        //ListView 의 참조값
        ListView listView=findViewById(R.id.listView);

        //ListView 에 출력할 SampleData
        names=new ArrayList<>();
        names.add("김구라");
        names.add("해골");
        names.add("원숭이");
        for(int i=0; i<100; i++){
            names.add("아무게"+i);
        }
        //ListView 에 연결할 아답타 객체 생성하기
        // new ArrayAdapter<>( Context , layout resource , 모델 )
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        //아답타를 ListView 에 연결하기
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        listView.setOnItemLongClickListener(this);

        //버튼에 리스너 등록
        Button addBtn=findViewById(R.id.addBtn);
        addBtn.setOnClickListener(view -> {
            //1. EditText 에 입력한 문자열을 읽어와서
            EditText inputName=findViewById(R.id.inputName);
            String name=inputName.getText().toString();
            //2. names (모델 ) 에 추가하고
            names.add(name);
            //3. 아답타에 names(모델) 이 변경되었다고 알린다.
            adapter.notifyDataSetChanged();
            //4. 마지막 위치까지 부드럽게 스크롤하기
            int position=adapter.getCount(); //전체 아이템의 갯수
            listView.smoothScrollToPosition(position);
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // i 는 클릭한 Item 의 인덱스 값
        Log.d("MainActivity", "i:"+i);
        // 클릭한 Item 에 출력된 이름
        String clickedName=names.get(i);
        // 토스트(가벼운메세지) 출력
        Toast.makeText(this, clickedName, Toast.LENGTH_SHORT).show();
    }
    //ListView 의 cell 을 오랬동안 클릭하면 호출되는 메소드
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        /*
        //알림창에 있는 버튼을 눌렀을때 호출되는 메소드를 가지고 있는 리스너 객체
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int result) {
                if( result == DialogInterface.BUTTON_POSITIVE ){//긍정버튼을 눌렀을때
                    // i 번째 인덱스의 아이템을 제거
                    //1. 모델에서 제거 하고
                    names.remove(i);
                    //2. 모델이 변경되었다고 아답타에 알리면 ListView 가 업데이트 된다.
                    adapter.notifyDataSetChanged();
                }
            }
        };

        new AlertDialog.Builder(this)
                .setTitle("알림")
                .setMessage("삭제 할까요?")
                .setPositiveButton("네", listener)
                .setNegativeButton("아니요", listener)
                .create()
                .show();
        */
        new AlertDialog.Builder(this)
                .setTitle("알림")
                .setMessage("삭제 할까요?")
                .setPositiveButton("네", (a, b)->{
                    //1. 모델에서 제거 하고
                    names.remove(i);
                    //2. 모델이 변경되었다고 아답타에 알리면 ListView 가 업데이트 된다.
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("아니요", null)
                .create()
                .show();

        return false;
    }
}









