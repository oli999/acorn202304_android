package com.example.step05fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/*
    [Fragment]

    - 액티비티의 제어하에 존재하는 mini Controller
    - 재활용을 염두에 두고 만드는 경우가 많다
    - 재활용이라는 것은 여러개의 액티비티에서 활용된다는 의미

    [ Fragment 만드는 방법 ]
    1. Fragment 클래스를 상속 받는다.
    2. 프레그먼트의 layout xml 문서를 만든다.
    3. onCreateView() 메소드를 오버라이딩 한다.
*/
public class MyFragment extends Fragment implements View.OnClickListener{
    TextView textView;
    //해당 프레그먼트가 제어할 View 객체를 만들어서 리턴해주는 메소드
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //1. fragment_my.xml 문서를 전개해서 View 를 만든다음
        View view=inflater.inflate(R.layout.fragment_my, container, false);
        //만든 View 객체에서 TextView 의 참조값을 얻어낸다
        textView=view.findViewById(R.id.textView);
        //TextView 에 OnClick 리스너를 등록한다.
        textView.setOnClickListener(this);
        //2. 해당 View 를 리턴해 준다.
        return view;
    }

    @Override
    public void onClick(View view) {
        //TextView 에 출력한 문자열을 숫자로 바꿔서 얻어낸다.
        int count=Integer.parseInt(textView.getText().toString());
        //count 를 1 증가 시킨다.
        count++;
        //TextView 에 문자열로 바꿔서 출력한다.
        textView.setText(Integer.toString(count));
        /*
            만일 프레그먼트에서 현재 자신을 제어하고 있는 액티비티에 어떠한 데이터를
            전달하고자 한다면 어떻게 해야 할까???
         */

        //이 fragment 를 제어하고 있는 액티비티의 참조값 얻어내기
        FragmentActivity fa=getActivity();
        //만일 이 액티비티가 MyFragmentListener type 이 맞다면
        if(fa instanceof MyFragmentListener){
            //액티비티의 참조값을 MyFragmentListener type 으로 casting 해서
            MyFragmentListener ma=(MyFragmentListener)fa;
            ma.sendMsg("hello!");
        }
    }

    //액티비티에서 특정 시점에 호출할 예정인 메소드
    public void reset(){
        textView.setText("0");
    }
    //이 fragment 에서 전달하는 메세지를 받을 액티비티에서 구현할 인터페이스를 클래스 안에 정의 하기
    public interface MyFragmentListener{
        public void sendMsg(String msg);
    }
}
