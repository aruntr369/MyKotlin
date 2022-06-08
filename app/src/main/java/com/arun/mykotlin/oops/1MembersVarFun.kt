package com.arun.mykotlin.oops

fun main(){
    var namee=Book("hello")
    namee.style()
    namee.page=100
    namee.style()
    var neww=Book("new",500)
    neww.style()
}
class Book(name:String){
    var page=121
    var name=name
    init {
        println("opened $name")
    }
    fun style(){
        println("pages are $page\'s of $name")
    }
    constructor(name:String,page:Int) : this(name) {this.page=page
        println("in constructor")
    }

}