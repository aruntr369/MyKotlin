package com.arun.mykotlin

fun main(){
    val addup = addup(4, 5)
    println("ans  $addup")
    var name :String?="arun"
    //name=null
    println(name?.length)
    name?.let { println(it.length) }
}
fun  addup(a:Int,b:Int):Int{
    return a+b
}