package com.example.serene.Apidata

import com.example.example.First
import com.example.example.GetMemoryData
import com.example.serene.GetData.GetFreeStyleData
import com.example.serene.JournalingActivity.FreeStyleDataClass
import com.example.serene.JournalingActivity.FreeStyleDatatext
import com.example.serene.JournalingActivity.JournalingCreateDataClass
import com.example.serene.JournalingActivity.MemoryDataClass
import com.example.serene.JournalingActivity.MyData
import com.example.serene.Login.ForgetpasswordData
import com.example.serene.Login.LoginDataClass
import com.example.serene.Login.ResetPassworddataClass
import com.example.serene.Login.VerifyotpdataClass
import com.example.serene.Signup.RegisterDataClass
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface Myinterface {

    @FormUrlEncoded
    @POST("user/register")
    fun myname(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<RegisterDataClass>

    @FormUrlEncoded
    @POST("user/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<LoginDataClass>

    @FormUrlEncoded
    @POST("user/forgetpassword")
    fun forgerpassword(
        @Field("email") email: String,
    ): Call<ForgetpasswordData>

    @FormUrlEncoded
    @POST("user/verifyotp")
    fun verifyotp(
        @Field("email") email: String,
        @Field("otp") otp: String,
    ): Call<VerifyotpdataClass>

    @FormUrlEncoded
    @POST("user/resetpassword")
    fun resetpassword(
        @Field("uid") uid: String,
        @Field("password") password: String,
    ): Call<ResetPassworddataClass>


    @POST("journaling/create")
    fun create(
        @Header("token") token: String,
        @Body answers: MyData,
    ): Call<JournalingCreateDataClass>


    @Multipart
    @POST("journaling/memory")
    fun memory(
        @Header("token") token: String,
        @Part("caption") caption: RequestBody,
        @Part data: MultipartBody.Part,
    ): Call<MemoryDataClass>

    @POST("journaling/freestyle")
    fun freestyle(
        @Header("token") token: String,
        @Body text: FreeStyleDatatext,
    ): Call<FreeStyleDataClass>

    //get data
    @GET("journaling/get/freestyle")
    fun fetchfreestyle(@Header("token") token: String)
    : Call<GetFreeStyleData>


    @GET("journaling/get/memory")
    fun fetchmemory(@Header("token") token: String)
    : Call<GetMemoryData>

    @GET("journaling/get/morning")
    fun fetchmornign(@Header("token") token: String
    ): Call<First>

    @GET("journaling/get/night")
    fun fetchNight(@Header("token") token: String)
    : Call<First>

    @GET("journaling/get/gratitude")
    fun fetchgratitude(@Header("token") token: String)
    : Call<First>
}
