package com.example.hellokotlin

class StarBucks{
    // null 이 가능한 String type 필드
    var location:String? = null
        set(value) { //필드에 값을 넣어줄때 실행되는 블럭
            //field 는 location 을 가리키고 value 는 넣을값을 가리킨다
            field=value+" 지점"
        }
        get() {
            if(field==null){
                return "지점명 없음"
            }else{
                return field
            }
        }

}

fun main(){
    val s1=StarBucks()
    s1.location="강남"
    println(s1.location)

    val s2=StarBucks()
    println(s2.location)
}