package com.example.step04gallery;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView=findViewById(R.id.imageView);
        TextView writer=findViewById(R.id.writer);
        TextView caption=findViewById(R.id.caption);
        TextView regdate=findViewById(R.id.regdate);

        //DetailActivity 가 활성화 될때 전달 받은 Intent 객체의 참조값 얻어오기
        //MainActivity 에서 생성한 Intent 객체이기 때문에
        // "dto" 라는 키값으로 GalleryDto 객체가 들어 있다.
        Intent intent=getIntent();
        GalleryDto dto=(GalleryDto)intent.getSerializableExtra("dto");
        writer.setText(dto.getWriter());
        caption.setText(dto.getCaption());
        regdate.setText(dto.getRegdate());
        //이미지 출력(Glide 를 활용)
        Glide.with(this)
                .load(dto.getImagePath())
                .fitCenter()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);

    }
}





