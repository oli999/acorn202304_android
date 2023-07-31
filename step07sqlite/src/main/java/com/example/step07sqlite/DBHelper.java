package com.example.step07sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/*
    DB 생성 및 리셋을 도와주는 도우미 클래스 만들기
    - SQLiteOpenHelper 추상 클래스를 상속 받아서 만든다.
 */
public class DBHelper extends SQLiteOpenHelper {
    //생성자
    public DBHelper(@Nullable Context context, @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //App 에서 DB 를 처음 사용할때 호출되는 메소드
    @Override
    public void onCreate(SQLiteDatabase db) {
        //사용할 테이블을 만들면 된다.
        String sql="CREATE TABLE todo " +
                "(num INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "content TEXT, regdate TEXT)";
        //SQLiteDataBase 객체를 이용해서 실행한다.
        db.execSQL(sql);
    }
    //DBHelpler 객체를 생성할때 version 숫자가 올라가면(변경되면) 호출되는 메소드
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //업그래이드할 내용을 작성하면 된다.
        db.execSQL("DROP TABLE IF EXISTS todo");
        //다시 만들어 질수 있도록 onCreate() 메소드를 호출한다.
        onCreate(db);
    }
}
