package com.example.hellokotlin
/*
    클래스 선언시 기본값을 상속을 받지 못하게 되어 있다.
    마치 java 에서  final class Phone{ } 처럼...
    상속을 받을수 있게 하려면 open 이라는 예약어를 붙여 준다.
 */
open class Phone{
    fun call(){
        println("전화를 걸어요!")
    }
}

open class HandPhone : Phone(){ // Phone 클래스를 상속받기
    fun mobileCall(){
        println("이동중에 전화를 걸어요!")
    }
    //재정의 가능한 메소드로 만들려면 open 예약어를 붙여야 한다.
    open fun takePicture(){
        println("100 만 화소의 사진을 찍어요!")
    }
}

class SmartPhone : HandPhone(){
    fun doInternet(){
        println("인터냇을 해요!")
    }
    // override 라는 예약어를 이용해서 open 된 메소드를 오버라이드 할수가 있다.
    override fun takePicture(){
        //필요시 부모의 메소드를 호출할수도 있다. (java 와 동일)
        super.takePicture()
        println("1000 만 화소의 사진을 찍어요!")
    }
}

fun main(){
    val p1=Phone()
    val p2=HandPhone()
    //Phone 클래스를 상속받은 클래스로 생성한 객체 이므로 3개의 메소드 모두를 사용할수 있다.
    p2.call()
    p2.mobileCall()
    p2.takePicture()

    val p3=SmartPhone()
    p3.doInternet()
    p3.takePicture()
}








