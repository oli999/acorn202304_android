package com.example.hellokotlin

import java.util.Scanner


fun main(){
    //Scanner 객체를 생성해서
    val scan=Scanner(System.`in`)
    //숫자를 하나 입력 받는다
    print("숫자입력:")
    val inputNum=scan.nextInt()

    var result:String
    //입력한 숫자가 홀수인지 짝수인지 판별 해서 결과를 변수에 담는다.
    if(inputNum%2 == 1){
        result="$inputNum 은 홀수 입니다"
    }else{
        result="$inputNum 은 짝수 입니다"
    }
    //값을 리턴하는 if 문
    val result2 = if(inputNum%2 == 1){
        "$inputNum 은 홀수 입니다"
    }else{
        "$inputNum 은 짝수 입니다"
    }
    //좀더 간략히 표현하면
    val result3 = if(inputNum%2 == 1) "$inputNum 은 홀수 입니다" else "$inputNum 은 짝수 입니다"

    val result4 = if(inputNum%2 == 1){
        println("작업중...")
        //만일 if 문의 블럭내에 여러줄이 있다면 마지막 줄이 리턴된다.
        "$inputNum 은 홀수 입니다"
    }else{
        println("작업중...")
        "$inputNum 은 짝수 입니다"
    }

    println(result)
    println(result2)
    println(result3)
    println(result4)

}









