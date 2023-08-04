package com.example.hellokotlin

//매개변수에 전달된 문자열의 길이를 리턴하는 함수
fun getLength(str:String?):Int?{
    //length 는 Int? type 이다
    val length = str?.length
    return length
}

/*
      Elvis 연산자는  좌측의 값이 null 이면 우측의 기본값을 남기는 연산자

      값  ?:  기본값
 */
fun getLength2(str:String?):Int{
    //length 는 Int type 이다
    val length = str?.length ?: 0  //Elvis 연산자 :?
    return length
}

fun getLength3(str:String?):Int{
    //length 는 Int type 이다
    val length = str?.length ?: return 0 //여기서 함수 리턴(종료)도 가능하다
    return length
}
fun getLength4(str:String?):Int{
    //length 는 Int type 이다
    val length = str?.length ?: run{
        //결과를 남기기 위해서 여러줄의 코드 실행이 필요하다면 run 블럭에서 작업하면된다.
        println("str 이 null 이네 어쩌지?")
        println("몰라 그냥 0 을 남기자")
        0
    }
    return length
}

fun getLength5(str:String?):Int{
    //length 는 Int type 이다
    val length = str?.length ?: run{
        //결과를 남기기 위해서 여러줄의 코드 실행이 필요하다면 run 블럭에서 작업하면된다.
        println("str 이 null 이네 어쩌지?")
        println("몰라 그냥 0 을 리턴하자")
        return 0
    }
    return length
}

fun main(){
    //4 가 리턴된다.
    val result = getLength("abcd")
    //getLength() 함수는 null 을 리턴할 가능성도 있다
    val result2:Int? = getLength(null)
    //getLength2() 함수는  null 이 리턴되지 않고 문자열이 null 이면 0 가 리턴된다.
    val result3:Int = getLength2(null)

    // run{} 블럭이 수행되는것 확인하기
    getLength4(null)
    getLength5(null)
}