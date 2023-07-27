package com.example.hellokotlin

// run 했을때 실행의 흐름이 시작되는 main 함수 만들기
fun main(){
    println("main 함수가 시작이 되었습니다")

    /*
        in java => public void a(){ }
        in kotlin => fun a():Unit{ }  or  fun a(){ }
        코틀린에서 Unit 은 원시 type 이라고 지칭하고 java 의 void 와 비슷한 역활을 한다.
     */

    // 함수명( ):리턴type { }
    fun a():Unit{
        println("a 함수 호출됨!")
    }

    a()

    //이름이 없는 함수를 만들어서 그 참조값을 변수에 담기
    var b = fun(){}

    /*
        대입연산자의 우측에 있는 함수를 관찰해 보면
        리턴 type : 없다(Unit)
        함수에 전달해야 하는 인자 : 없다
     */
    var c:()->Unit = fun():Unit{}

    // 매개변수는 1개, type 은 String, 리턴 type 은 Unit(없다)
    var d:(String)->Unit = fun(str:String){}

    // 매개변수는 1개 type 은 String, 리턴 type 은 String
    var e:(String)->String = fun(str:String):String{
        return "hello"
    }
    // 매개변수는 2개 type 은 Int, Int , 리턴 type 도 Int
    var sum:(Int, Int)->Int = fun(a:Int, b:Int):Int{
        return a+b
    }

    println("main 함수가 종료 됩니다")
}