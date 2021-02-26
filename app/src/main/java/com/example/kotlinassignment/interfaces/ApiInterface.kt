package com.example.kotlinassignment.interfaces

import com.example.kotlinassignment.DataModel.Result
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("assignment")
    fun getAssignmentData(): Call<Result>

}