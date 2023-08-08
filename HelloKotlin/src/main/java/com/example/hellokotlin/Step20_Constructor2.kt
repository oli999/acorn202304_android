package com.example.hellokotlin

open class MyData{
    //3가지 종류의 생성자
    constructor()
    constructor(num:Int)
    constructor(num:Int, name:String)
}

class YourData {
    //@JvmOverloads 어노테이션을 생성자에 붙이기
    //기본값 지정 (값이 전달되지 않았을 경우에 사용할 기본값)
   @JvmOverloads constructor(num:Int=0, name:String="")
}

// primary 생성자에도 적용가능
class OurData @JvmOverloads constructor(num:Int=0, name:String="")

class OurData2 @JvmOverloads constructor(var num:Int=0,var name:String="")

data class OurData3 @JvmOverloads constructor(var num:Int=0,var name:String="")

fun main(){
    //용도에 따라서 다양한 생성자를 호출할수 있다.
    val d1=MyData()
    val d2=MyData(1)
    val d3=MyData(1, "김구라")

    // @JvmOverloads 어노테이션을 붙이고 매개 변수에 기본값을 지정하면
    // 모든 종류의 생성자가 자동으로 만들어 진다고 생각하면 된다.
    val d4=YourData()
    val d5=YourData(2)
    val d6=YourData(2, "해골")
}





