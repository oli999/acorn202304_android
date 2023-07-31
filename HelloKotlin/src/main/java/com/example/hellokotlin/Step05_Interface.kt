package com.example.hellokotlin

// kotlin 에서 인터페이스 만들기
interface Remocon{
    fun up()
    fun down()
}
//인터페이스를 구현한 클래스 만들기
class MyRemocon : Remocon{
    override fun up() {
        println("무언가를 올려요!")
    }
    override fun down() {
        println("무언가를 내려요!")
    }
}

fun main(){
    val r1=MyRemocon()
    r1.up()
    r1.down()
    /*
        in  java
           Remocon r = new Remocon(){
                @override
                public void up(){}
                @override
                public void down(){}
            };
        in kotlin
     */
    // 클래스를 정의함과 동시에 객체를 생성하는것이 object 키워드이다
    val r2:Remocon = object : Remocon{
        override fun up() {
            println("체널을 올려요")
        }
        override fun down() {
            println("체널을 내려요")
        }
    }
    r2.up()
    r2.down()
}






