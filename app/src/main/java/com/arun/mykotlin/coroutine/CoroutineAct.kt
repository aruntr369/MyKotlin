package com.arun.mykotlin.coroutine

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.arun.mykotlin.R
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class CoroutineAct : AppCompatActivity() {
    private val TAG = "CoroutineAct"

    lateinit var textView : TextView
    lateinit var btnStartAct : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        textView = findViewById(R.id.textView)
        btnStartAct = findViewById(R.id.btnStartAct)


        //startingDelay()
        //suspendFun()
        //coroutineContexts()

//        Log.d(TAG, "onCreate: Before runBlocking")
//        runBlock()
//        Log.d(TAG, "onCreate: After runBlocking")

        //coroutineJobs()
        //asyncAwait()
        lifeCyclecope()
        

    }
    fun lifeCyclecope(){
        btnStartAct.setOnClickListener {
            //GlobalScope.launch {//does not stop when activity destroys
            lifecycleScope.launch {
                while (true) {
                    delay(1000L)
                    Log.d(TAG, "onCreate: Still Running")
                }
            }
            GlobalScope.launch {
                while (true) {
                    delay(5000L)
                    Intent(this@CoroutineAct,SecondCorAct::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
            }

        }
    }
    
    fun asyncAwait(){
        GlobalScope.launch(Dispatchers.IO){
            val time = measureTimeMillis { 
//                val answer1 = networkCall()
//                val answer2 = networkCall()

//                var answer1: String? = null
//                var answer2: String? = null
//                val job1 = launch { answer1 = networkCall() }
//                val job2 = launch { answer2 = networkCall2() }
//                job1.join()
//                job2.join()

                val answer1 = async { networkCall() }
                val answer2 = async { networkCall2() }

                Log.d(TAG, "asyncAwait: ${answer1.await()}")
                Log.d(TAG, "asyncAwait: ${answer2.await()}")
            }
            Log.d(TAG, "asyncAwait: Request took $time ms..")
        }
        
    }
    suspend fun networkCall(): String{
        delay(3000L)
        return "Answer1"
    }
    suspend fun networkCall2(): String{
        delay(3000L)
        return "Answer2"
    }
    
    fun coroutineJobs(){
        val job = GlobalScope.launch(Dispatchers.Default){
//            repeat(5){
//                Log.d(TAG, "coroutineJobs: is still working...")
//                delay(1000L)
//            }
            Log.d(TAG, "coroutineJobs: Starting long running calculation...")
            withTimeout(3000L){//stop this after 3sec
                for (i in 30..40){
                    if (isActive){//it will check job is canceled or not
                        Log.d(TAG, "coroutineJobs: Result fori = $i: ${fib(i)}")
                    }
                }
            }

            Log.d(TAG, "coroutineJobs: ending long running calculation...")

        }

        runBlocking {
//            job.join()//after job complete below code execute
            delay(2000)
            //job.cancel()//stop job after 2 sec and continue main thread
            Log.d(TAG, "coroutineJobs: Main thread is continuing")
        }
    }

    fun fib(n: Int): Long {
        return if(n ==0) 0
        else if(n== 1) 1
        else fib(n-1) + fib(n-2)
    }

    fun runBlock(){
        //it block main thread
        runBlocking {
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG, "onCreate: Finish IO coroutine 1 runBlocking")
            }
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG, "onCreate: Finish IO coroutine 2 runBlocking")
            }
            Log.d(TAG, "onCreate: Started runBlocking")
            delay(5000L)
            Log.d(TAG, "onCreate: Eng runBlocking")

        }
    }

    fun coroutineContexts(){
        GlobalScope.launch(Dispatchers.IO){
            Log.d(TAG, "coroutineContexts: at start ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            //used to change thread
            withContext(Dispatchers.Main){
                Log.d(TAG, "coroutineContexts: set Text ${Thread.currentThread().name}")
                textView.text = answer
            }
        }
    }

    fun suspendFun() {
        //pause the execution of the current coroutine
        GlobalScope.launch {
            val netWorkCallAns1 = doNetworkCall()
            val netWorkCallAns2 = doNetworkCall2()
            Log.d(TAG, "suspendFun: $netWorkCallAns1")
            Log.d(TAG, "suspendFun: $netWorkCallAns2")
        }
    }
    suspend fun doNetworkCall(): String {
        delay(3000)
        return "return  String"
    }
    suspend fun doNetworkCall2(): String {
        delay(3000)
        return "return  String2"
    }

    fun startingDelay() {
        GlobalScope.launch {
            delay(3000L)
            Log.d(TAG, "onCreate: coroutine${Thread.currentThread().name}")
        }
        Log.d(TAG, "onCreate:thread ${Thread.currentThread().name}")
    }


}