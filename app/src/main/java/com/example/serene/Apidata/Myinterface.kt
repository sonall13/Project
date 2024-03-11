package com.example.serene.Apidata

import com.example.serene.GetData.GetFreeStyleData
import com.example.serene.GetData.GetGratitudeDataClass
import com.example.serene.GetData.GetMemoryData
import com.example.serene.GetData.GetMorningData
import com.example.serene.GetData.GetNightDataClass
import com.example.serene.JournalingActivity.FreeStyleDataClass
import com.example.serene.JournalingActivity.FreeStyleDatatext
import com.example.serene.JournalingActivity.JournalingCreateDataClass
import com.example.serene.JournalingActivity.MemoryDataClass
import com.example.serene.JournalingActivity.MyData
import com.example.serene.JournalingActivity.Mymemories
import com.example.serene.Login.ForgetpasswordData
import com.example.serene.Login.LoginDataClass
import com.example.serene.Login.ResetPassworddataClass
import com.example.serene.Login.VerifyotpdataClass
import com.example.serene.Signup.RegisterDataClass
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
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
    fun create(@Header("token") token: String,
               @Body answers: MyData
    ):Call<JournalingCreateDataClass>


    @POST("journaling/memory")
    fun memory(
        @Header("token") token: String,
        @Body request: Mymemories
    ) : Call<MemoryDataClass>


    @POST("journaling/freestyle")
    fun freestyle(
        @Header("token") token: String,
        @Body text : FreeStyleDatatext
    ) : Call<FreeStyleDataClass>

    //get data

    @Headers("token")
    @GET("journaling/get/freestyle")
    fun fetchfreestyle(): Call<GetFreeStyleData>

    @Headers("token")
    @GET("journaling/get/memory")
    fun fetchmemory(): Call<GetMemoryData>

    @Headers("token")
    @GET("journaling/get/morning")
    fun fetchmornign(): Call<GetMorningData>

    @Headers("token")
    @GET("journaling/get/night")
    fun fetchNight(): Call<GetNightDataClass>

    @Headers("token")
    @GET("journaling/get/gratitude")
    fun fetchgratitude(): Call<GetGratitudeDataClass>
}
