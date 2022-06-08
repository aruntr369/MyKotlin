package com.arun.mykotlin.oops

open class Vehicle{
    fun drive(name: String){
        println("$name can drive ")
    }

}
interface Drivable {
    var maxSpeed:Int
    fun drive():String
    fun breake(){
        println("have break")
    }

}
open class Car(name: String,Range:Int): Vehicle() {
    open var power=100

}
class ElectricCar(name: String, Range: Int,batteryRange:Int) : Car(name, Range) {
    override var power =batteryRange*6
    var namee="tes"
}
class ToyCar(override var maxSpeed: Int) :Drivable{
    override fun drive(): String = "drivng interface"
//    override fun drive(): String {
//        return "drivng interface"
//    }

}

fun main(){
    var tesla=ElectricCar("tesla",20,80)
    var audi=Car("audi",100)
    tesla.power=50
    tesla.drive(tesla.namee)
}