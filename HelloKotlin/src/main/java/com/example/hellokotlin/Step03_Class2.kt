package com.example.hellokotlin
/*
class Person constructor(name:String){
    //필드 선언
    var name:String
    //초기화 블럭
    init {
        //생성자의 인자로 전달받은 값을 매개 변수에 저장
        this.name=name
    }
}
*/

//위를 줄이면 아래와 같다
class Person(var name:String)