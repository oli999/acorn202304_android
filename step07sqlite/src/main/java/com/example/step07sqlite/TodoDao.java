package com.example.step07sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    private DBHelper dbHelper;
    //생성자
    public TodoDao(DBHelper dbHelper){
        this.dbHelper=dbHelper;
    }
    //할일 저장
    public void insert(Todo todo){
        //수정가능한 SQLiteDatabase 객체의 참조값 얻어오기
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String sql="INSERT INTO todo" +
                " (content, regdate)" +
                " VALUES(?, datetime('now','localtime'))";
        // ? 에 순서대로 바인딩할 인자를 Object[] 에 준비한다.
        Object[] args={todo.getContent()};
        //sql 문 실행하기
        db.execSQL(sql, args);
        db.close(); // close() 를 호출해야 실제로 반영된다.
    }
    //할일 정보를 수정하는 메소드
    public void update(Todo todo){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String sql="UPDATE todo" +
                " SET content=?" +
                " WHERE num=?";
        //? 에 바인딩할 데이터를 Object[] 배열에 순서대로 담아서
        Object[] args={todo.getContent(), todo.getNum()};
        // execSQL() 메소드의 인자로 Object[] 배열을 전달하면 ? 에 순서대로 바인딩된다.
        db.execSQL(sql, args);
        db.close();
    }
    //할일 정보를 삭제하는 메소드
    public void delete(int num){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String sql="DELETE FROM todo WHERE num=?";
        Object[] args={num};
        db.execSQL(sql, args);
        db.close();
    }
    //할일 1개의 정보를 리턴하는 메소드
    public Todo getData(int num){
        Todo todo=null;
        //읽기전용 SQLiteDatabase 객체의 참조값 얻어오기
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String sql="SELECT content, regdate" +
                " FROM todo" +
                " WHERE num=?";
        //query 문에는 String[] 배열에 selection 인자를 순서대로 준비해야 한다.
        String[] args={Integer.toString(num)};
        // rawQuery() 메소드의 인자로 String[] 배열을 전달하면 ? 에 순서대로 바인딩된다.
        Cursor result=db.rawQuery(sql, args);
        //만일 select 된 값이 있다면
        if(result.moveToNext()){
            todo=new Todo();
            todo.setNum(num);
            // 0 번째 칼럼에 select 된 문자열을 Todo 객체에 담는다.
            todo.setContent(result.getString(0));
            // 1 번째 칼럼에 select 된 문자열을 Todo 객체에 담는다.
            todo.setRegdate(result.getString(1));
        }
        return todo;
    }
    //모든 할일 목록을 리턴하는 메소드
    public List<Todo>  getList(){
        List<Todo> list=new ArrayList<>();
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String sql="SELECT num, content, regdate" +
                " FROM todo" +
                " ORDER BY num ASC";
        Cursor cursor=db.rawQuery(sql, null);
        //반복문 돌면서 Cursor 에 있는 값을
        while (cursor.moveToNext()){
            //추출해서 Todo 객체에 담아서
            Todo tmp=new Todo();
            tmp.setNum(cursor.getInt(0));
            tmp.setContent(cursor.getString(1));
            tmp.setRegdate(cursor.getString(2));
            //List 에 누적 시킨다.
            list.add(tmp);
        }
        return list;
    }
}









