package com.panat.mvvm.exampleproject.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.panat.mvvm.exampleproject.model.ResponseEvent
import com.panat.mvvm.exampleproject.service.GithubService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val retrofit: GithubService) : ViewModel() {
    val events: LiveData<List<ResponseEvent>>
        get() = get()

    fun get(): MutableLiveData<List<ResponseEvent>> {
        val data = MutableLiveData<List<ResponseEvent>>()
        retrofit.getEvents().enqueue(object : Callback<List<ResponseEvent>> {
            override fun onFailure(call: Call<List<ResponseEvent>>, t: Throwable) {
                data.postValue(null)
            }

            override fun onResponse(call: Call<List<ResponseEvent>>, response: Response<List<ResponseEvent>>) {
                data.postValue(response.body())
            }
        })
        return data
    }
}

