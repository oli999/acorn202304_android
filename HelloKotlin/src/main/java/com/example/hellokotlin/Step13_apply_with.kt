package com.example.hellokotlin

class Gun{
    fun prepare(){
        println("총을 발사할 준비를 합니다")
    }
    fun fire(){
        println("빵야~")
    }
    fun end(){
        println("마무리 작업을 합니다.")
    }
}

//가상의 다이얼 로그 클래스
class Dialog{
    fun setTitle(title:String){}
    fun setContent(content:String){}
    fun create(){}
}

fun main(){
    val g1=Gun()
    //총을 여러번 쏘고 싶다면?
    g1.fire()
    g1.fire()
    g1.fire()
    println("-----")
    //이미 만들어진 객체의 참조값을 여러번 사용하고 싶을때 with 구문을 사용하면된다.
    with(g1){
        prepare()
        fire()
        fire()
        fire()
        end()
    }

    val d1=Dialog()
    with(d1){
        setTitle("제목")
        setContent("내용")
        create()
    }
    //객체 생성과 동시에 필요한 작업을 한 후에 참조값을 대입할수 있다.
    val d2=Dialog().apply {
        setTitle("제목")
        setContent("내용")
        create()
    }
}








