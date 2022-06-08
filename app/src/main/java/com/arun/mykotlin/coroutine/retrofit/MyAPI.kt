package com.arun.mykotlin.coroutine.retrofit

import com.arun.mykotlin.coroutine.retrofit.Comment
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MyAPI {
    @GET("/comments")
    suspend fun getComments(): Response<List<Comment>>
}