package com.example.example

import com.example.serene.GetData.Data
import com.google.gson.annotations.SerializedName


data class GetMemoryData (

  @SerializedName("status"  ) var status  : String?         = null,
  @SerializedName("message" ) var message : String?         = null,
  @SerializedName("data"    ) var data    : ArrayList<Data> = arrayListOf()

)