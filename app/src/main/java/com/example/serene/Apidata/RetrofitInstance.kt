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

//        fun journaling() : Myinterface{

//        val client = OkHttpClient.Builder().addInterceptor { chain ->
//            val newRequest: Request = chain.request().newBuilder()
//                .addHeader("Accept", "application/json")
//                .addHeader("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY1ZTZmZDcyM2MyY2I1MmI5ZjgwMTZmOSIsImlhdCI6MTcwOTczMzQwOH0.O3xI51ZJkQKvwaNsMX4-4UQlv3d-Fmt2-9-vL9cPxOU")
//                .addHeader("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY1ZTZmZDcyM2MyY2I1MmI5ZjgwMTZmOSIsImlhdCI6MTcwOTczMzQwOH0.O3xI51ZJkQKvwaNsMX4-4UQlv3d-Fmt2-9-vL9cPxOU")
//                .build()
//            chain.proceed(newRequest)
//        }.build()

//        var a = GsonBuilder().setLenient().create()

//        val retrofit: Retrofit = Retrofit.Builder()
////            .client(client)
//            .baseUrl("https://6gn1hp4c-3000.inc1.devtunnels.ms/api/")
//            .addConverterFactory(GsonConverterFactory.create(a))
//            .build()

//            val retrofit: Retrofit = Retrofit.Builder()
//                .baseUrl("https://6gn1hp4c-3000.inc1.devtunnels.ms/api/journaling/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            val service: Myinterface = retrofit.create(Myinterface::class.java)
//
//     return service
//    }

//}