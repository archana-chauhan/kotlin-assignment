package com.example.kotlinassignment.CommonService

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kotlinassignment.DataModel.Result
import com.example.kotlinassignment.DataModel.Zone
import com.example.kotlinassignment.interfaces.ApiInterface
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    val liveDataResponse: MutableLiveData<List<Zone>> = MutableLiveData()

    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("http://demo1929804.mockable.io/")
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

    fun loadServerData(): MutableLiveData<List<Zone>>? {
        val retrofitCall  = create().getAssignmentData()
        retrofitCall.enqueue(object : Callback<Result> {
            override fun onFailure(call: Call<Result>, t: Throwable?) {
                Log.e("on Failure :", "retrofit error" + Log.getStackTraceString(t))
            }
            override fun onResponse(call: Call<Result>, response: retrofit2.Response<Result>) {
                Log.d("retrofit", "onResponse:: " + response.toString())
                val list  = response.body()?.ResponseData?.zone
                for (i in list.orEmpty()){
                    Log.e("on response:", i.zone)
                }
                liveDataResponse.value = list
                Log.e("hasActiveObservers 1", liveDataResponse.hasActiveObservers().toString()+" check")
                Log.e("on response 2 :", liveDataResponse.toString()+" check")
            }
        })
        return liveDataResponse
    }
}