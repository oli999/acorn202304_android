package com.example.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputNum=findViewById(R.id.inputNum);
        Button testBtn=findViewById(R.id.testBtn);

        testBtn.setOnClickListener(view->{
            int num=Integer.parseInt(inputNum.getText().toString());
            int num2=num%2;
            if(num2==0){
                Toast.makeText(this, "짝수입니다.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "홀수입니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
}