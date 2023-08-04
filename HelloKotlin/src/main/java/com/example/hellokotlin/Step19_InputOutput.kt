package com.example.hellokotlin

import java.io.File
import java.io.FileWriter
import java.util.Scanner

/*
    반복문 3번 돌면서 키보드로 부터 문자열을 각각 3 줄을 입력 받아서
    c:\acorn202304\myFolder\msgs.txt 파일을 생성해서 입력한 문자열
    저장하기
 */

fun main(){
    //키보드로 부터 입력 받을 객체
    val scan=Scanner(System.`in`)
    //입력 받은 메세지를 저장할 List
    val list= mutableListOf<String>()
    //반복문 돌면서 메세지 3 줄 입력 받기
    for( i in 0..2){
        print("메세지 입력:")
        val msg=scan.nextLine()
        //입력 받은 문자열을 List 에 누적 시키기
        list.add(msg)
    }
    //문자열을 파일에 출력할 객체
    val f=File("c:/acorn202304/myFolder/msgs.txt")
    //만일 msgs.txt 파일이 존재 하지 않으면
    if(!f.exists()){
        //새로 만들기
        f.createNewFile()
    }
    //위의 File 객체를 이용해서  append mode 인 FileWriter 객체 얻어내기
    val fw=FileWriter(f, true)
    //반복문 돌면서 List 에 누적된 문자열을 FileWriter 객체를 이용해서 출력하기
    list.forEach{
        fw.append(it+"\n")
    }
    fw.close()
    println("파일에 문자열을 기록 했습니다.")
}











