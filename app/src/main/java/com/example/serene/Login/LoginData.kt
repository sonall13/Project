package com.example.serene.Login

import com.google.gson.annotations.SerializedName


data class LoginData (

  @SerializedName("_id"      ) var Id       : String? = null,
  @SerializedName("name"     ) var name     : String? = null,
  @SerializedName("email"    ) var email    : String? = null,
  @SerializedName("password" ) var password : String? = null,
  @SerializedName("__v"      ) var _v       : Int?    = null

)