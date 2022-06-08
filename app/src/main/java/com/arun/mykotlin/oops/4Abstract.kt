package com.arun.mykotlin.oops

abstract class mammel(
    private val name: String,
    private val orgin: String,
    private val weight: Int
) {
    abstract var maxspeed: Int
    abstract fun run()
    abstract fun breath()

    fun displayDetails() {
        println("name $name ,orgin $orgin ,weight $weight " + "maxspeed $maxspeed")
    }
}

class Human(override var maxspeed: Int, name: String, orgin: String, weight: Int) : mammel(name, orgin, weight) {
    override fun run() {
        println("runs in 2 leg")
    }

    override fun breath() {
        println("breath through nose")
    }
}
class Elephant(name: String, orgin: String, weight: Int, override var maxspeed: Int) : mammel(name, orgin, weight) {
    override fun run() {
        println("run 4 leg")
    }

    override fun breath() {
        println("breath through trunk")
    }
}

fun main(){
    var human=Human(30,"Arun","India",60)
    var elephant=Elephant("pampadiRaj","china",5000,20)

    human.run()
    elephant.run()

    human.breath()
    elephant.breath()
}