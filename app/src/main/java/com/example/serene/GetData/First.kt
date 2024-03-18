package com.example.example

import com.example.serene.GetData.Second
import com.google.gson.annotations.SerializedName


data class First (

  @SerializedName("status"  ) var status  : String?         = null,
  @SerializedName("message" ) var message : String?         = null,
  @SerializedName("data"    ) var data    : ArrayList<Second> = arrayListOf()

)