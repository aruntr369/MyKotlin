package com.arun.mykotlin.coroutine.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arun.mykotlin.R
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URl = "https://jsonplaceholder.typicode.com/"
class CoroutineRetrofit : AppCompatActivity() {
    private  val TAG = "CoroutineRetrofit"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_retrofit)

        val api = Retrofit.Builder()
            .baseUrl(BASE_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)
        
        GlobalScope.launch(Dispatchers.IO) {
//            val comments = api.getComments().await()
//            for (comment in comments){
//                Log.d(TAG, "onCreate: ${comment.toString()}")
//            }
            val response = api.getComments()
            if (response.isSuccessful){
            for (comment in response.body()!!){
                Log.d(TAG, "onCreate: ${comment.toString()}")
            }

            }

        }

//        api.getComments().enqueue(object : Callback<List<Comment>> {
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                if (response.isSuccessful){
//                    response.body()?.let { 
//                        for (comment in it){
//                            Log.d(TAG, "onResponse: ${comment.toString()}")
//                        }
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                Log.e(TAG, "onFailure: $t", )
//            }
//
//        })
    }
}