package com.example.serene.JournalingActivity

import com.google.gson.annotations.SerializedName


data class MemoryDataClass (

  @SerializedName("status"  ) var status  : String? = null,
  @SerializedName("message" ) var message : String? = null,
  @SerializedName("data"    ) var MemoryData    : MemoryData?   = MemoryData()

)