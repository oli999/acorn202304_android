package com.example.step08customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View as View

/*
    custom View 클래스 정의하기
    - View 를 상속 받아서 만든다
    - 적절한 생성자를 정의한다.
    - onDraw() 메소드를 오버라이드 해서 화면을 구성한다.
 */
class MyView(context: Context, attrs:AttributeSet): View(context, attrs) {

    //배열에 미리 색상을 준비해 놓는다
    val colors:Array<Int> = arrayOf(Color.GREEN, Color.YELLOW, Color.BLUE)
    //인덱스를 관리할 필드
    var index=0

    //View 가 차지 하고 있는 화면에 Canvas 객체를 이용해서 그림 그리기(화면 구성하기)
    override fun onDraw(canvas: Canvas?) {
        //index 에 해당하는 색상으로 화면을 체운다
        canvas?.drawColor(colors[index])
    }
    //MyView 에 터치 이벤트가 발생하면 호출되는 메소드
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //색생이 바뀌는 로직을 수행하고
        index++
        if(index==3){
            index=0
        }
        //화면을 다시 갱신시킨다
        invalidate() //결과적으로 onDraw() 메소드가 다시 호출된다.
        return super.onTouchEvent(event)
    }
}








