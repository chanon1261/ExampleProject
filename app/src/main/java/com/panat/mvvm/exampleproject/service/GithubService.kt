package com.panat.mvvm.exampleproject.service
import com.panat.mvvm.exampleproject.model.ResponseEvent
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("events")
    fun getEvents(): Call<List<ResponseEvent>>
}
