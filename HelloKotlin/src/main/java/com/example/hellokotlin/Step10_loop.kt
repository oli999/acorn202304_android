package com.example.hellokotlin

fun main(){
    // 수정 불가능한 String 목록 (ReadOnly)
    val names= listOf<String>("김구라","해골","원숭이","주뎅이","덩어리")
    //모든 아이템을 순서대로 참조
    for(item in names){
        println(item)
    }
    //index 가 필요하다면
    for(index in names.indices){ // names 목록의 방번호로만 이루어진 목록
        println("$index 번째 인덱스 : ${names[index]}")
    }
    //1 부터 10 까지 출력
    for(num in 1..10){
        println(num)
    }
    println("-----")
    //1 부터 10 까지 홀수만 출력
    for(num in 1..10 step 2){
        println(num)
    }
    println("-----")
    //10 부터 1까지 출력
    for(num in 10 downTo 1){
        println(num)
    }
    println("-----")
    //names 배열의 아이템을 역순으로 참조
    for(index in names.size-1 downTo 0){
        println("$index 번째 인덱스 : ${names[index]}")
    }
}