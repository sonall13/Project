package com.example.serene.Signup

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("name"     ) var name     : String? = null,
  @SerializedName("uname"    ) var uname    : String? = null,
  @SerializedName("email"    ) var email    : String? = null,
  @SerializedName("password" ) var password : String? = null,
  @SerializedName("_id"      ) var Id       : String? = null,
  @SerializedName("__v"      ) var _v       : Int?    = null

)


