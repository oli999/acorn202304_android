package com.example.step07sqlite;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.step07sqlite.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //view binding 설정
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        /*
            DBHelper 객체를 생성해서 참조값을 필드에 저장하기
            name 은  DB 의 이름을 마음대로 정해서 전달하면된다.
         */
        dbHelper=new DBHelper(this, "MyDB.sqlite",
                null, 1);
        //할일 목록을 담을 List 를 TodoDao 객체를 이용해서 얻어내기
        List<Todo> list=new TodoDao(dbHelper).getList();
        //ListView 에 연결할 아답타 객체 생성
        TodoAdapter adapter=new TodoAdapter(this, R.layout.listview_cell, list);
        //ListView 에 아답타 연결
        binding.listView.setAdapter(adapter);
        //할일 추가 버튼에 리스너 연결
        binding.addBtn.setOnClickListener(view->{
            //1. EditText 에 입력한 문자열을 읽어와서
            String content=binding.inputText.getText().toString();
            //2. Todo 에 담고
            Todo todo=new Todo();
            todo.setContent(content);
            //3. TodoDao 를 이용해서 DB 에 저장하고
            TodoDao dao=new TodoDao(dbHelper);
            dao.insert(todo);
            //4. 할일 목록을 새로 읽어와서
            List<Todo> newList=dao.getList();
            //5. 아답타에 넣어주고 (덮어쓰기)
            adapter.list=newList;
            //6. 모델의 내용이 바뀌었다고 아답타에 알려서 ListView 가 업데이트 되도록 한다.
            adapter.notifyDataSetChanged();
            //7. ListView 의 가장 아래쪽이 화면에 보일수 있도록 부드럽게 스크롤 시키기
            binding.listView.smoothScrollToPosition(adapter.getCount());
        });
        //ListView 의 cell 을 오랬동안 클릭하고 있으면 호출되는 메소드
        binding.listView.setOnItemLongClickListener((adapterView, view, index, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("알림")
                    .setMessage("삭제 하시겠습니까?")
                    .setPositiveButton("네", (dialogInterface, i1) -> {
                        TodoDao dao=new TodoDao(dbHelper);
                        //클릭한 셀의 id 를 이용해서 삭제
                        dao.delete((int)id);
                        //목록을 새로 얻어와서 아답타에 넣어주고
                        adapter.list=dao.getList();
                        //모델의 내용이 바뀌었다고 아답타에 알려서 ListView 가 업데이트 되도록 한다.
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("아니요", null)
                    .create()
                    .show();
            return false;
        });
    }

}




