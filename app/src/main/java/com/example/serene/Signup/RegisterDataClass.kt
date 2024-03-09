package com.example.serene.Signup

import com.google.gson.annotations.SerializedName


data class RegisterDataClass (

  @SerializedName("status"  ) var status  : String? = null,
  @SerializedName("message" ) var message : String? = null,
  @SerializedName("data"    ) var data    : Data?   = Data()

)