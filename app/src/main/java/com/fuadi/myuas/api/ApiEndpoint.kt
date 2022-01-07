package com.fuadi.myuas.api

import com.fuadi.myuas.Model
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("data.php")
    fun data() : Call<Model>
}