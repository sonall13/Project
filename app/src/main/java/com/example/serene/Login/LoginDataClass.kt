package com.example.serene.Login

import com.example.serene.Login.LoginData
import com.google.gson.annotations.SerializedName


data class LoginDataClass(

    @SerializedName("status"  ) var status: String? = null,
    @SerializedName("message" ) var message: String? = null,
    @SerializedName("data"    ) var data: LoginData = LoginData(),
    @SerializedName("token"   ) var token: String? = null

)