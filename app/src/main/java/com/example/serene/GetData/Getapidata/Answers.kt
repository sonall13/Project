package com.example.serene.GetData.Getapidata

import com.google.gson.annotations.SerializedName


data class Answers (

  @SerializedName("q1" ) var q1 : ArrayList<String> = arrayListOf(),
  @SerializedName("q2" ) var q2 : String?           = null,
  @SerializedName("q3" ) var q3 : String?           = null

)