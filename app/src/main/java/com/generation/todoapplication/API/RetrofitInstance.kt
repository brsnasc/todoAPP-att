package com.generation.todoapplication.API

import com.generation.todoapplication.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: APIService by lazy {
        retrofit.create(APIService::class.java)

    }

}