package com.example.serene.Login

import com.google.gson.annotations.SerializedName

data class VerifyotpdataClass (

  @SerializedName("status"  ) var status  : String? = null,
  @SerializedName("message" ) var message : String? = null,
  @SerializedName("uid"     ) var uid     : String? = null

)