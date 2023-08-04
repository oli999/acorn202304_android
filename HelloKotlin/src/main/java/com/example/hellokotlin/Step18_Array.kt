package com.example.hellokotlin


fun main(){
    //정수 배열(Array)
    // in java =>   int[] nums = {10, 20, 30};
    val nums:Array<Int> = arrayOf<Int>(10, 20, 30)
    //문자 배열
    // in java =>   String[] names = {"kim", "lee", "park"};
    val names:Array<String> = arrayOf("kim", "lee", "park")
    //Any 배열
    // in java =>   Object[] goods = {10, "kim", true};
    val goods:Array<Any> = arrayOf(10, "kim", true)

    for(item in nums){
        println(item)
    }
    println("-----")
    for(index in nums.indices){
        println("$index : ${nums.get(index)}") // java 와 다르게 배열이지만 .get() 메소드가 있다.
    }
    println("-----")
    for(index in nums.indices){
        println("$index : ${nums[index]}")  // 배열의 전형적인 참조도 가능
    }
    //아이템 수정
    nums.set(0, 999)  // set() 메소드가 존재 한다.
    nums[1]=888 // 배열의 전형적인 참조를 이용해서 수정도 가능
    //다양한 Collection 함수들를 모두 사용할 수 있다.
    names.forEach {
        println(it)
    }
}