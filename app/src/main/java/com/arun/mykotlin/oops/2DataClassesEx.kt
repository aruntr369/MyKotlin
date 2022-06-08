package com.arun.mykotlin.oops

data class user(val id:Int,var name:String)

fun main(){
    var user1=user(1,"aa")
    var user2=user(1,"bb")
    println(user1.equals(user2))
    user2.name="aa"
    println(user1.equals(user2))

    var updatedUserr =user1.copy(name="cc")
    println(user1)
    println(updatedUserr)

    println(updatedUserr.component1())
    println(updatedUserr.component2())

    var (idd,namee)=updatedUserr
    println("id=$idd  name=$namee")
}

