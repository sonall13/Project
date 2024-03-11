package com.example.serene.GetData

import com.google.gson.annotations.SerializedName


data class GetMemoryData (

  @SerializedName("status"  ) var status  : String? = null,
  @SerializedName("message" ) var message : String? = null,
  @SerializedName("data"    ) var data    : ImageMemoryData?   = ImageMemoryData()

)