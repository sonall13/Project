package com.example.serene.Apidata

import android.widget.ImageView
import com.example.serene.JournalingActivity.Answers
import com.example.serene.JournalingActivity.JournalingCreateDataClass
import com.example.serene.JournalingActivity.MemoryDataClass
import com.example.serene.Login.ForgetpasswordData
import com.example.serene.Login.LoginDataClass
import com.example.serene.Login.ResetPassworddataClass
import com.example.serene.Login.VerifyotpdataClass
import com.example.serene.Signup.RegisterDataClass
import com.google.gson.JsonObject
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.PartMap

interface Myinterface {

    @FormUrlEncoded
    @POST("user/register")
    fun myname(
        @Field("name") lname: String,
        @Field("uname") uname: String,
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

//    @POST("journaling/create")
//    fun create(
//        @Header("Authorization") authorization: String,
//        @Body category: JSONObject,
////        @Body partMap: HashMap<String, Any>,
//    ): Call<JournalingCreateDataClass>

    @FormUrlEncoded
    @POST("journaling/create")
    fun create(
        @Field("category") category: String,
        @Field("answers") answers: HashMap<String ,Any>
    ):Call<JournalingCreateDataClass>

    @FormUrlEncoded
    @POST("journaling/memory")
    fun memory(
        @Field("caption") caption: String,
        @Field("image") image: ImageView
    ) : Call<MemoryDataClass>
}
