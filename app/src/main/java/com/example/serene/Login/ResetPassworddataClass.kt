package com.example.serene.Login

import com.google.gson.annotations.SerializedName


data class ResetPassworddataClass (

  @SerializedName("status"  ) var status  : String? = null,
  @SerializedName("message" ) var message : String? = null

)