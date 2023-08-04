package com.example.hellokotlin

fun main(){
    //수정가능한 Map
    val mem:MutableMap<String, Any> = mutableMapOf<String, Any>()
    //Map 에 데이터 넣는 방법 1
    mem.put("num", 1)
    mem.put("name", "김구라")
    mem.put("isMan", true)

    //수정가능한 Map
    val mem2 = mutableMapOf<String, Any>()
    //Map 에 데이터 넣는 방법 2
    mem2["num"]=2
    mem2["name"]="원숭이"
    mem2["isMan"]=true

    //MutableMap 이기 때문에 수정가능
    mem["num"]=999
}






