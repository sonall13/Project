package com.example.serene.Apidata

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitInstance {
    val client = OkHttpClient.Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    fun method(): Myinterface {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://6gn1hp4c-3000.inc1.devtunnels.ms/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: Myinterface = retrofit.create(Myinterface::class.java)

        return service
    }
}
