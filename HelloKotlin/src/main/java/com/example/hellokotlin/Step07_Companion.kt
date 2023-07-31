package com.example.hellokotlin

/*
    [ in  java ]

    class Util{
        public static int number=10
        public String version="1.0"
        public static void get(){ }
        public void send(){}
    }

    new Util().send();
    new Util().version;
    Util.get();
    Util.number;
 */

class Util{
    //Util 클래스와 함께하는 동반객체
    companion object{
        //동반객체의 필드와 메소드(함수)를 정의하면 된다
        val version:String="1.0"
        fun send(){
            println("전송합니다")
        }
    }
}

fun main(){
    Util.send()
    println(Util.version)
}










