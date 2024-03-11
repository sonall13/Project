package com.example.serene.GetData

import com.google.gson.annotations.SerializedName


data class GetNightDataClass (

  @SerializedName("status"  ) var status  : String? = null,
  @SerializedName("message" ) var message : String? = null,
  @SerializedName("data"    ) var data    : NightData?   = NightData()

)