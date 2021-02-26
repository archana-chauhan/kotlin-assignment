package com.example.kotlinassignment.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinassignment.CommonService.RetrofitService
import com.example.kotlinassignment.DataModel.Zone

class AssignmentViewModel: ViewModel() {
    private val mService  =  RetrofitService()

    fun getData() : MutableLiveData<List<Zone>>? {
        return mService.loadServerData()
    }
}