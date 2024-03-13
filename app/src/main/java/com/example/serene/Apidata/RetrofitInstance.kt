package com.example.serene.Apidata

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {


    fun method(): Myinterface {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://6gn1hp4c-3000.inc1.devtunnels.ms/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: Myinterface = retrofit.create(Myinterface::class.java)

        return service
    }
}
